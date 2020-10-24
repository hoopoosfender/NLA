package com.nla;


import com.nla.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.nla.model.Book;

@SpringBootApplication
public class BooksWebApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(BooksWebApplication.class, args);
    }

}