//package org.djulb.store.controller;
//
//
//import org.djulb.store.io.StoreClientFile;
//import org.djulb.store.io.StoreClientMinio;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/web")
//public class TestController {
//
//    @Autowired
//    StoreClientFile storeClientFile;
//
//    @Autowired
//    StoreClientMinio storeClientMinio;
//
//    @GetMapping("")
//    public String test() throws IOException {
//        System.out.println("www");
//        String qqq = storeClientFile.read("qqq");
//        storeClientMinio.write("bojan", "id", "hello");
//        String read = storeClientMinio.read("bojan", "id");
//
//        storeClientFile.write("text.txt", "THis is some content");
//        storeClientFile.read("text.txt");
//
//        System.out.println(read);
//
//        return "welcome";
//    }
//}
