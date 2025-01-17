package com.xa.pembekalan.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Book extends BaseEntity {
    public Book(String title, Integer stock, Date publishedAt) {
        this.title = title;
        this.synopsis = "Sinopsis buku " + title;
        this.stock = stock;
        this.publishedAt = publishedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "authorId", referencedColumnName = "authorId")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "publisherId", referencedColumnName = "id")
    private Publisher publisher;

    private String title;

    private String synopsis;

    private Integer stock;

    private Date publishedAt;
}
