package com.example.bookauthorrest.repository;

import com.example.bookauthorrest.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Optional<Author> findByEmail(String email);

}
