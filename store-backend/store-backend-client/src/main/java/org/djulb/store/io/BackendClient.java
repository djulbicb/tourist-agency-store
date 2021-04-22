package org.djulb.store.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class BackendClient {
    public void write() {
        RestTemplate restTemplate = new RestTemplate();

        String url = formatWriteUrl();
        restTemplate.postForEntity(url, "content", String.class);
        System.out.println("StorageFilesWriter");
    }

    public void read() {
        RestTemplate restTemplate = new RestTemplate();

        String url = formaReadUrl();
        restTemplate.postForEntity(url, "", String.class);
        System.out.println("StorageFilesWriter");
    }

    private String formatWriteUrl() {
        return String.format("http://%s:%s/api/database/write","localhost", "8200");

    }

    private String formaReadUrl() {
        return String.format("http://%s:%s/api/database/write","localhost", "8200");

    }

}
