package org.djulb.store.controller;

import org.djulb.store.io.BookRepository;
import org.djulb.store.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/database")
public class BackendDatabaseController {

    @Autowired
    BookRepository repository;

    @RequestMapping("write")
    public String write () {
        Book book = new Book();
        book.setName("bojan");
        book.setName("djulbic");

        repository.save(book);

        List<Book> all = repository.findAll();
        System.out.println(all);
        return "hello from write CLIENT";
    }

    @RequestMapping("read")
    public String read () {
        Book book = new Book();
        book.setName("bojan");
        book.setName("djulbic");

        repository.save(book);

        List<Book> all = repository.findAll();
        System.out.println(all);
        return "hello from read CLIENT";
    }
}
