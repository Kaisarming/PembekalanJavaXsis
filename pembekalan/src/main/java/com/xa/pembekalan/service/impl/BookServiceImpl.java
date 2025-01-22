package com.xa.pembekalan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.xa.pembekalan.dto.request.BookRequestDto;
import com.xa.pembekalan.dto.response.BookResponseDto;
import com.xa.pembekalan.entity.Book;
import com.xa.pembekalan.repository.BookRepository;
import com.xa.pembekalan.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book b : books) {
            BookResponseDto bookResponseDto = new BookResponseDto();
            bookResponseDto.setCategory(b.getCategory());
            bookResponseDto.setAuthor(b.getAuthor());
            bookResponseDto.setPublisher(b.getPublisher());
            bookResponseDto.setId(b.getId());
            bookResponseDto.setTitle(b.getTitle());
            bookResponseDto.setSynopsis(b.getSynopsis());
            bookResponseDto.setStock(b.getStock());
            bookResponseDto.setPublishedAt(b.getPublishedAt());
            bookResponseDtos.add(bookResponseDto);
        }

        return bookResponseDtos;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // @Override
    // public Book saveBook(BookRequestDto bookRequestDto) {
    // Book book = new Book();
    // book.setCategory(bookRequestDto.getCategory());
    // book.setAuthor(bookRequestDto.getAuthor());
    // book.setPublisher(bookRequestDto.getPublisher());
    // book.setId(bookRequestDto.getId());
    // book.setTitle(bookRequestDto.getTitle());
    // book.setSynopsis(bookRequestDto.getSynopsis());
    // book.setStock(bookRequestDto.getStock());
    // book.setPublishedAt(bookRequestDto.getPublishedAt());
    // return bookRepository.save(book);
    // }

    @Override
    public BookResponseDto getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElse(null);
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setSynopsis(book.getSynopsis());
        bookResponseDto.setStock(book.getStock());
        bookResponseDto.setPublishedAt(book.getPublishedAt());
        return bookResponseDto;
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
}
