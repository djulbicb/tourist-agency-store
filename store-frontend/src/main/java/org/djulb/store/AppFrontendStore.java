package org.djulb.store;

import org.djulb.store.config.StorageMinioConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@Import({StorageMinioConfiguration.class, StorageFilesConfiguration.class})
@SpringBootApplication()
//@EntityScan(basePackages = {"org.djulb.store"})
//@ComponentScan(basePackages = {"org.djulb.store"})
//@ConfigurationProperties(prefix = "yaml")
//@PropertySource(value = "classpath:foo.yaml")
public class AppFrontendStore {
    public static void main(String[] args) {
        SpringApplication.run(AppFrontendStore.class, args);
    }
}