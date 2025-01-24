package com.xa.pembekalan.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.xa.pembekalan.config.ApiEndpoints;
import com.xa.pembekalan.dto.request.PublisherRequestDto;
import com.xa.pembekalan.dto.response.PublisherResponseDto;
import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.entity.Publisher;
import com.xa.pembekalan.service.PublisherService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    PublisherService publisherService;

    @GetMapping()
    public ModelAndView getAllPublishers(Model model) {
        ModelAndView view = new ModelAndView("publisher/index");
        String title = "Publisher Page";
        // Untuk get data dari api publisher dan menjadikannya return berupa Map object
        Map response = restTemplate.getForObject(ApiEndpoints.PUBLISHERS, Map.class);
        model.addAttribute("publishers", response.get("data"));
        model.addAttribute("title", title);
        Publisher publisher = new Publisher();
        view.addObject("publisher", publisher);
        return view;
    }
}
