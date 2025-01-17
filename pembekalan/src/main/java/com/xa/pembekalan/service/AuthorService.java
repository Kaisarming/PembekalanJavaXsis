package com.xa.pembekalan.service;

import java.util.List;

import com.xa.pembekalan.dto.request.AuthorRequestDto;
import com.xa.pembekalan.dto.response.AuthorResponseDto;
import com.xa.pembekalan.dto.response.UserResponseDto;
import com.xa.pembekalan.entity.Author;

public interface AuthorService {
    List<AuthorResponseDto> getAllAuthors();

    Author saveAuthor(AuthorRequestDto author);

    AuthorResponseDto getAuthorId(Integer id);

    void deleteAuthorById(Integer id);
}
