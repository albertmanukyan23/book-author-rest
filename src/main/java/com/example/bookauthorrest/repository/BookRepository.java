package com.example.bookauthorrest.repository;

import com.example.bookauthorrest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
