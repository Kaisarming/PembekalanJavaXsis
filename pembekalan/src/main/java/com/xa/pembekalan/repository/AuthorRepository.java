package com.xa.pembekalan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xa.pembekalan.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
