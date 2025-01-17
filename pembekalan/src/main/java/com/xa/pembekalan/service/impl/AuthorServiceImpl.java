package com.xa.pembekalan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.pembekalan.dto.request.AuthorRequestDto;
import com.xa.pembekalan.dto.response.AuthorResponseDto;
import com.xa.pembekalan.dto.response.UserResponseDto;
import com.xa.pembekalan.entity.Author;
import com.xa.pembekalan.repository.AuthorRepository;
import com.xa.pembekalan.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    /*
     * private ModelMapper modelMapper() {
     * return new ModelMapper();
     * }
     */

    @Override
    public List<AuthorResponseDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();

        // Cara 1
        List<AuthorResponseDto> authorResponseDtos = new ArrayList<>();
        for (Author a : authors) {
            AuthorResponseDto authorResponseDto = new AuthorResponseDto();
            authorResponseDto.setAuthorId(a.getAuthorId());
            authorResponseDto.setName(a.getName());
            authorResponseDto.setPublishedBook(a.getPublishedBook());
            authorResponseDtos.add(authorResponseDto);
        }

        // Cara 2 (Jangan lupa uncomment modelMapper() kalau mau pakai ini)
        // List<AuthorResponseDto> authorResponseDtos = authors.stream().map(a ->
        // modelMapper().map(a, AuthorResponseDto.class)).collect(Collectors.toList());
        return authorResponseDtos;
    }

    @Override
    public Author saveAuthor(AuthorRequestDto authorRequestDto) {
        Author data = new Author();
        data.setAuthorId(authorRequestDto.getAuthorId());
        data.setName(authorRequestDto.getName());
        data.setPublishedBook(authorRequestDto.getPublishedBook());
        return authorRepository.save(data);
    }

    @Override
    public AuthorResponseDto getAuthorId(Integer id) {
        Author author = authorRepository.findById(id).orElse(null);
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setAuthorId(author.getAuthorId());
        authorResponseDto.setName(author.getName());
        authorResponseDto.setPublishedBook(author.getPublishedBook());
        return authorResponseDto;
    }

    @Override
    public void deleteAuthorById(Integer id) {
        authorRepository.deleteById(id);
    }
}
