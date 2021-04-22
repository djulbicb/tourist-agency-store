package org.djulb.store;

import org.djulb.store.request.ApiGatewayProperties;
import org.djulb.store.request.ProxyRequestTransformer;
import org.djulb.store.request.impl.HeadersRequestTransformer;
import org.djulb.store.request.impl.URLRequestTransformer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties({ApiGatewayProperties.class})
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public ProxyRequestTransformer headerTransformer() {
        return new HeadersRequestTransformer();
    }

    @Bean
    public ProxyRequestTransformer urlTransformer(ApiGatewayProperties properties) {
        return new URLRequestTransformer(properties);
    }

}
