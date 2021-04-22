package org.djulb.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AppBackendDatabase {
    public static void main(String[] args) {
        SpringApplication.run(AppBackendDatabase.class, args);
    }
}
