package org.djulb.store.controller;

import org.djulb.store.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/minio/**")
@RestController
public class MinioController {

    ApplicationProperties properties;

    @Autowired
    public MinioController(ApplicationProperties properties) {
        this.properties = properties;
    }

    @GetMapping("read")
    public String read () {
        return "Hello from minio READ";
    }

    @GetMapping("write")
    public String write () {
        return "Hello from minio WRITE";
    }

    @GetMapping("")
    public String hello () {
        return "Hello from minio";
    }
}
