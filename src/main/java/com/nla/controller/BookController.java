package com.nla.controller;

import com.nla.model.People;
import com.nla.model.Book;
import com.nla.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

@RestController
public class BookController {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping(value = "/peoplebooks/{personId}", produces = "application/json; charset=UTF-8")
    public List<Book> getBooks(@PathVariable long personId) {
        Optional<People> people = this.peopleRepository.findById(personId);
        if (people.isPresent()) {
            return people.get().getBooks();
        } else {
            return new ArrayList<Book>();
        }
    }

}