package com.xa.pembekalan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.xa.pembekalan.dto.request.AuthorRequestDto;
import com.xa.pembekalan.dto.response.AuthorResponseDto;
import com.xa.pembekalan.service.AuthorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("author/index"); // "author/index" adalah tempat taruh file
        List<AuthorResponseDto> authorResponseDtos = authorService.getAllAuthors();
        String title = "Author List";
        view.addObject("authors", authorResponseDtos);
        view.addObject("title", title);
        // RestTemplate r = new RestTemplate();
        // String s = r.getForObject("http://localhost:8080/api/book", String.class);
        // System.out.println(s);
        return view;
    }

    @GetMapping("/form")
    public ModelAndView authorForm() {
        ModelAndView view = new ModelAndView("author/form");
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        view.addObject("author", authorResponseDto);
        return view;
    }

    @PostMapping("/save")
    public ModelAndView saveAuthor(@ModelAttribute AuthorRequestDto authorRequestDto) {
        authorService.saveAuthor(authorRequestDto);
        return new ModelAndView("redirect:/author");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editAuthor(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("author/form");
        AuthorResponseDto authorResponseDto = authorService.getAuthorId(id);
        view.addObject("author", authorResponseDto);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthorById(id);
        return new ModelAndView("redirect:/author");
    }

}
