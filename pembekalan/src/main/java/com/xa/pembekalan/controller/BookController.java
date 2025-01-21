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
import com.xa.pembekalan.dto.response.PublisherResponseDto;
import com.xa.pembekalan.entity.Book;
import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.repository.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.xa.pembekalan.service.AuthorService;
import com.xa.pembekalan.service.BookService;
import com.xa.pembekalan.service.PublisherService;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    PublisherService publisherService;

    @Autowired
    BookService bookService;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("")
    public String getAllBooks(Model model) {
        String title = "Book Page";
        Map response = restTemplate.getForObject(ApiEndpoints.BOOKS, Map.class);
        model.addAttribute("books", response.get("data"));
        model.addAttribute("title", title);
        return "book/index";
    }

    @GetMapping("/form")
    public ModelAndView showForm() {
        ModelAndView view = new ModelAndView("book/form");
        Book book = new Book();
        view.addObject("book", book);

        List<AuthorResponseDto> authors = authorService.getAllAuthors();
        view.addObject("authors", authors);

        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);

        List<PublisherResponseDto> publishers = publisherService.getAllPublishers();
        view.addObject("publishers", publishers);

        return view;
    }

}
