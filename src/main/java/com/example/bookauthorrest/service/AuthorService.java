package com.example.bookauthorrest.service;

import com.example.bookauthorrest.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author  save(Author author);

    List<Author> findAll();

    Optional<Author> findById(int id);

    void deleteById(int id);

    Optional<Author> findByEmail(String email);

    boolean existsById(int id);

}
