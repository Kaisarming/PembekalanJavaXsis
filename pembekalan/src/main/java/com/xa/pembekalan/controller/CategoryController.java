package com.xa.pembekalan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.repository.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("category/index");
        String title = "Category Page";
        List<Category> categories = categoryRepository.findAll();
        view.addObject("title", title);
        view.addObject("categories", categories);
        return view;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("category/form");
        Category category = new Category();
        view.addObject("category", category);
        return view;
    }

    @PostMapping("/store")
    public ModelAndView save(@ModelAttribute Category category, BindingResult result) {
        if (!result.hasErrors()) {
            categoryRepository.save(category);
        }
        return new ModelAndView("redirect:/category");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("category/form");
        Category category = categoryRepository.findById(id).orElse(null);
        view.addObject("category", category);
        return view;
    }
}
