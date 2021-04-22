package org.djulb.store.request.impl;
import org.apache.http.client.methods.RequestBuilder;
import org.djulb.store.request.ApiGatewayProperties;
import org.djulb.store.request.ProxyRequestTransformer;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

public class URLRequestTransformer extends ProxyRequestTransformer {
    private ApiGatewayProperties apiGatewayProperties;

    public URLRequestTransformer(ApiGatewayProperties apiGatewayProperties) {
        this.apiGatewayProperties = apiGatewayProperties;
    }

    @Override
    public RequestBuilder transform(RequestBuilder rb, HttpServletRequest request) throws URISyntaxException {
        String requestURI = request.getRequestURI();
        URI uri;
        if (request.getQueryString() != null && !request.getQueryString().isEmpty()) {
            uri = new URI(getServiceUrl(requestURI, request) + "?" + request.getQueryString());
        } else {
            uri = new URI(getServiceUrl(requestURI, request));
        }

        rb.setUri(uri);
        return rb;
    }

    private String getServiceUrl(String requestURI, HttpServletRequest httpServletRequest) {
        Optional<ApiGatewayProperties.Endpoint> found = Optional.empty();
        for (ApiGatewayProperties.Endpoint e : apiGatewayProperties.getEndpoints()) {
            if (requestURI.matches(e.getPath()) && e.getMethod() == RequestMethod.valueOf(httpServletRequest.getMethod())) {
                found = Optional.of(e);
                break;
            }
        }
        ApiGatewayProperties.Endpoint endpoint = found.orElseThrow(() -> new RuntimeException("runtime"));
        return endpoint.getLocation() + requestURI;
    }
}