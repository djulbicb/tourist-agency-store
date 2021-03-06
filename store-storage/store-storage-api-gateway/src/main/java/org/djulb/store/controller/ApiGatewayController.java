package org.djulb.store.controller;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.djulb.store.request.ApiGatewayProperties;
import org.djulb.store.request.ProxyRequestTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/api/**")
@RestController
public class ApiGatewayController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private HttpClient httpClient;

    @Autowired
    ApiGatewayProperties gatewayProperties;

    @Autowired
    List<ProxyRequestTransformer> requestTransformers;

    @PostConstruct
    public void init() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
    }

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
    @ResponseBody
    public ResponseEntity<String> proxyRequest(HttpServletRequest request) throws IOException, URISyntaxException {
        HttpUriRequest proxiedRequest = createHttpUriRequest(request, requestTransformers);
        logger.info("request: {}", proxiedRequest);
        HttpResponse proxiedResponse = httpClient.execute(proxiedRequest);
        logger.info("Response {}", proxiedResponse.getStatusLine().getStatusCode());
        return new ResponseEntity<>(read(proxiedResponse.getEntity().getContent()), makeResponseHeaders(proxiedResponse), HttpStatus.valueOf(proxiedResponse.getStatusLine().getStatusCode()));
    }

    private HttpHeaders makeResponseHeaders(HttpResponse response) {
        HttpHeaders result = new HttpHeaders();
        Header h = response.getFirstHeader("Content-Type");
        result.set(h.getName(), h.getValue());
        return result;
    }

    private HttpUriRequest createHttpUriRequest(HttpServletRequest request, List<ProxyRequestTransformer> requestTransformers) throws URISyntaxException, IOException {
        RequestBuilder rb = RequestBuilder.create(request.getMethod());
        for (ProxyRequestTransformer transformer : requestTransformers) {
            transformer.transform(rb, request);
        }
        return rb.build();
    }

    private String read(InputStream input) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }
}
