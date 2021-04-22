package org.djulb.store.io;

import io.FileWrite;
import org.djulb.store.config.StorageFilesProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class StorageFilesWriter {

    @Autowired
    StorageFilesProperties properties;

    public void write (String fileName, String content) throws IOException {
        FileWrite.write(fileName, content);;
    }

    private String formatUrl() {
        RestTemplate restTemplate = new RestTemplate();

        String url = formatUrl();
        Object content = "";
        restTemplate.postForEntity(url, content, String.class);
        return String.format("http://%s:%s/api/files/write", properties.getUrl(), properties.getPort());
    }
}
