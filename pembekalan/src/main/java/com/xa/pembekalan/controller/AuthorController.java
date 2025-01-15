package com.xa.pembekalan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xa.pembekalan.dto.response.AuthorResponseDto;
import com.xa.pembekalan.service.AuthorService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("author/index"); // "author/index" adalah tempat taruh file
        List<AuthorResponseDto> authorResponseDtos = authorService.getAllAuthors();
        return view;
    }

}
