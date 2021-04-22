package org.djulb.store.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties({ApplicationProperties.class})
public class StorageMinioConfiguration extends WebMvcConfigurerAdapter {

    public StorageMinioConfiguration() {
        System.out.println("STOOOOOOOOOORE");
    }
}
