package com.xa.pembekalan.dto.response;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Integer authorId;
    private String name;
    private String publishedBook;
}
