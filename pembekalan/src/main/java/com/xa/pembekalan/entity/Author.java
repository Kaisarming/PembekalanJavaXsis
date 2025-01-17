package com.xa.pembekalan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "authors")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Author extends BaseEntity {

    public Author(String name, String publishedBook) {
        this.name = name;
        this.publishedBook = publishedBook;
    }

    @Id // Menandakan bahwa ini adalah primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Menandakan bahwa nilai id akan dihasilkan secara otomatis
    private Integer authorId;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String publishedBook;
}
