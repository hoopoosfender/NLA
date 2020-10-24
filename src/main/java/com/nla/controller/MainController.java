package com.nla.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nla.model.Book;
import com.nla.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class MainController {

    @Autowired
    private BookRepository bookRepository;

    private List<Book> feed() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/")
    public ModelAndView index(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.getModel().put("books", feed());
        return mv;
    }



}
