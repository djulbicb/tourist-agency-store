//package org.djulb.store.controller;
//
//import org.djulb.store.config.StorageFilesProperties;
//import org.djulb.store.io.StorageFilesReader;
//import org.djulb.store.io.StorageFilesWriter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
//@RequestMapping("/api/files/**")
//@RestController
//public class StorageFilesController {
//
//    @Autowired
//    StorageFilesProperties properties;
//
//    @GetMapping("")
//    public String hello () {
//        return "Hello from FILES storage";
//    }
//
//    @GetMapping("read")
//    public String read () throws IOException {
//        System.out.println("Hello from storage files controller read");
//        StorageFilesReader reader = new StorageFilesReader();
//        return reader.read("text.txt");
//    }
//
//    @PostMapping("write")
//    public String write (@RequestBody String request) throws IOException {
//        System.out.println("Hello from storage files controller write");
//        StorageFilesWriter writer = new StorageFilesWriter();
//        writer.write("text.txt", "sss bojan");
//        return "Hello from FILES WRITE";
//    }
//}
