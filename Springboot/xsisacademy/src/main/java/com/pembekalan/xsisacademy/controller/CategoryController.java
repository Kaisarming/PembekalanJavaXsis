package com.pembekalan.xsisacademy.controller;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pembekalan.xsisacademy.repository.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public ModelAndView getAllCategories() {
        ModelAndView view = new ModelAndView("category/index");
        String title = "Category Page";
        List<com.pembekalan.xsisacademy.entity.Category> categories = categoryRepository.findAll();
        view.addObject("title", title);
        return view;
    }

}
