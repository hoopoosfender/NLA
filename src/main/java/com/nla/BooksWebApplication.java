package com.nla;


import com.nla.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nla.model.Book;

@SpringBootApplication
public class BooksWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksWebApplication.class, args);
    }


    @Bean
    public CommandLineRunner bookDemo(BookRepository bookRepository) {
        return (args) -> {

            // create books
            bookRepository.save(new Book("Thinking in Java"));
            bookRepository.save(new Book("Beginning Java 2"));
            bookRepository.save(new Book("Java Gently"));
            bookRepository.save(new Book("Java 2 Platform Unleashed"));

            // fetch all books
            System.out.println("Books found with findAll():");
            System.out.println("---------------------------");
            for (Book book : bookRepository.findAll()) {
                System.out.println(book.toString());
            }
            System.out.println();

        };
    }

}