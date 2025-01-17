package com.xa.pembekalan.dto.response;

import com.xa.pembekalan.entity.Author;
import com.xa.pembekalan.entity.Category;
import com.xa.pembekalan.entity.Publisher;

import lombok.Data;

@Data
public class BookResponseDto {

    private Integer id;
    private Author author;
    private Category category;
    private Publisher publisher;
    private String title;
    private String synopsis;
    private String stock;
    private String publishedAt;
}
