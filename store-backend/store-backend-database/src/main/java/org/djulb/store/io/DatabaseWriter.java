package org.djulb.store.io;

import org.djulb.store.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseWriter {

    @Autowired
    BookRepository repository;

    public String write() {
        List<Book> all = repository.findAll();
        System.out.println(all);
        return "DatabaseWriter";
    }
}
