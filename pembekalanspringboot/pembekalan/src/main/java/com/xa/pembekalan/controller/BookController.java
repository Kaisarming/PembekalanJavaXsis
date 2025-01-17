package com.xa.pembekalan.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.pembekalan.dto.response.BookResponseDto;
import com.xa.pembekalan.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public ResponseEntity<?> getAllBooks() {
        List<BookResponseDto> bookResponseDtos = bookService.getAllBooks();
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", bookResponseDtos);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

}
