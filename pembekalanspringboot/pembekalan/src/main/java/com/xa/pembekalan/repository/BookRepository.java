package com.xa.pembekalan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xa.pembekalan.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
