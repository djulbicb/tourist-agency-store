package org.djulb.store.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class StoreClientFile {
    public void write(String fileName, String content) {
        RestTemplate restTemplate = new RestTemplate();

        String url = formatWriteUrl();
        restTemplate.postForEntity(url, content, String.class);
        System.out.println("StorageFilesWriter");
    }

    private String formatWriteUrl() {
        return String.format("http://%s:%s/api/files/write","localhost", "8200");

    }

    private String formaReadUrl() {
        return String.format("http://%s:%s/api/files/write","localhost", "8200");

    }

    public String read(String fileName) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        String url = formaReadUrl();
        String content = "Ovo je content";
        System.out.println("StorageFilesWriter");
        return restTemplate.getForObject(url, String.class);
    }
}
