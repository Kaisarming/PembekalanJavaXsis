package com.xa.pembekalan.dto.request;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private Integer authorId;
    private String name;
    private String publishedBook;
}
