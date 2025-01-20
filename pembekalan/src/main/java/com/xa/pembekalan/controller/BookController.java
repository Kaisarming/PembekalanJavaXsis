package com.xa.pembekalan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xa.pembekalan.config.ApiEndpoints;
import com.xa.pembekalan.dto.response.AuthorResponseDto;
import com.xa.pembekalan.dto.response.BookResponseDto;
import com.xa.pembekalan.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
public class BookController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("")
    public String getAllBooks(Model model) {
        String title = "Book Page";
        Map response = restTemplate.getForObject(ApiEndpoints.BOOKS, Map.class);
        model.addAttribute("books", response.get("data"));
        model.addAttribute("title", title);
        return "book/index";
    }

    // @Autowired
    // BookService bookService;

    // @GetMapping("")
    // public ModelAndView index() {
    // ModelAndView view = new ModelAndView("book/index");
    // List<BookResponseDto> bookResponseDtos = bookService.getAllBooks();
    // String title = "Book List";
    // view.addObject("title", title);
    // view.addObject("books", bookResponseDtos);
    // return view;
    // }

}
