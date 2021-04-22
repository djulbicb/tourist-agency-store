package org.djulb.store.io;


import io.FileRead;
import org.djulb.store.config.StorageFilesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class StorageFilesReader {

    @Autowired
    StorageFilesProperties properties;

    public String read(String fileName) throws IOException {
        return FileRead.readString(fileName);
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = formatUrl();
//        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
//
//        return response;
    }

    private String formatUrl() {
        return String.format("http://%s:%s/api/files/read", properties.getUrl(), properties.getPort());
    }
}
