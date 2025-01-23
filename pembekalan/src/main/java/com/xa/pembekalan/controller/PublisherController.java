package com.xa.pembekalan.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.xa.pembekalan.config.ApiEndpoints;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("")
    public String getAllPublishers(Model model) {
        String title = "Book Page";
        Map response = restTemplate.getForObject(ApiEndpoints.PUBLISHERS, Map.class);
        model.addAttribute("publishers", response.get("data"));
        model.addAttribute("title", title);
        return "publisher/index";
    }
}
