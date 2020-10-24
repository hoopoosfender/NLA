package com.nla.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nla.model.Book;
import com.nla.model.People;
import com.nla.repository.BookRepository;
import com.nla.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PeopleRepository peopleRepository;

    private List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    private List<People> getPeople() {
        return this.peopleRepository.findAll();
    }

    @GetMapping("/")
    public ModelAndView index(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.getModel().put("people", getPeople());
        return mv;
    }

    @GetMapping("/books")
    public ModelAndView books(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.getModel().put("books", getBooks());
        return mv;
    }

}
