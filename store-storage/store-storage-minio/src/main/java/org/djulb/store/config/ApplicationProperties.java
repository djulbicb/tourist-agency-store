package org.djulb.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "minio")
public class ApplicationProperties {
    @Value("${url}")
    public String url;

    @Value("${port}")
    public String port;

    @Value("${username}")
    public String username;

    @Value("${password}")
    public String password;
}
