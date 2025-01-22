package com.xa.pembekalan.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.pembekalan.dto.request.BookRequestDto;
import com.xa.pembekalan.dto.response.BookResponseDto;
import com.xa.pembekalan.entity.Book;
import com.xa.pembekalan.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/book")
public class BookControllerApi {

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

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookRequestDto bookRequestDto) {
        Book book = bookService.saveBook(bookRequestDto);
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("status", "200");
        resultMap.put("message", "success");
        resultMap.put("data", book);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}

// Untuk tes saveBook()
// {
// "id": 1,
// "author": {
// "authorId": 1,
// "name": "Toni Nababan"
// },
// "category": {
// "id": 1,
// "name": "Reference book"
// },
// "publisher": {
// "id": 1,
// "name": "Left Book Club"
// },
// "title": "My name is Matthew",
// "synopsis": "Sinopsis buku My Name is Matthew",
// "stock": 1090,
// "publishedAt": "1990-02-24T19:52:15.181+00:00"
// }