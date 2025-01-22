package com.xa.pembekalan.service;

import java.util.List;

import com.xa.pembekalan.dto.request.BookRequestDto;
import com.xa.pembekalan.dto.response.BookResponseDto;
import com.xa.pembekalan.entity.Book;

public interface BookService {
    List<BookResponseDto> getAllBooks();

    Book saveBook(BookRequestDto bookRequestDto);

    BookResponseDto getBookById(Integer id);

    void deleteBookById(Integer id);
}
