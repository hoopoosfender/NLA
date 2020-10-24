package com.nla.controller;

import com.nla.model.Book;
import com.nla.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(path = "/books", produces = "application/json; charset=UTF-8")
    public List<Book> feed() {
        return this.bookRepository.findAll();
    }

}