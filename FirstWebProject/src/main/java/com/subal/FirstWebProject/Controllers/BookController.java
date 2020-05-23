package com.subal.FirstWebProject.Controllers;

import com.subal.FirstWebProject.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

    private final BookRepository bookRepository;


    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getallBooks(Model model){

        model.addAttribute("books",
                bookRepository.findAll());
        System.out.println(" bookRepository.findAll()" +  bookRepository.findAll());

        return "books/list";
    }


}
