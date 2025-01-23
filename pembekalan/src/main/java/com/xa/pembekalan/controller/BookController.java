package com.xa.pembekalan.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xa.pembekalan.config.ApiEndpoints;
import com.xa.pembekalan.dto.request.AuthorRequestDto;
import com.xa.pembekalan.dto.request.BookRequestDto;
import com.xa.pembekalan.dto.response.AuthorResponseDto;
import com.xa.pembekalan.dto.response.BookResponseDto;
import com.xa.pembekalan.dto.response.PublisherResponseDto;
import com.xa.pembekalan.entity.Book;
import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.repository.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("book/index");
        List<BookResponseDto> bookResponseDtos = bookService.getAllBooks();
        String title = "Books List";
        view.addObject("books", bookResponseDtos);
        view.addObject("title", title);
        return view;
    }

    @GetMapping("/form")
    public ModelAndView bookForm() {
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

    @PostMapping("/save")
    public ModelAndView saveAuthor(@ModelAttribute BookRequestDto bookRequestDto) {
        bookService.saveBook(bookRequestDto);
        return new ModelAndView("redirect:/book");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editBook(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("book/form");
        BookResponseDto bookResponseDto = bookService.getBookById(id);
        view.addObject("book", bookResponseDto);

        List<AuthorResponseDto> authors = authorService.getAllAuthors();
        view.addObject("authors", authors);

        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);

        List<PublisherResponseDto> publishers = publisherService.getAllPublishers();
        view.addObject("publishers", publishers);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBook(@PathVariable Integer id) {
        bookService.deleteBookById(id);
        return new ModelAndView("redirect:/book");
    }

}
