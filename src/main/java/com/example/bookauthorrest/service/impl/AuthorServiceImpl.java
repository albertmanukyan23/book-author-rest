package com.example.bookauthorrest.service.impl;

import com.example.bookauthorrest.entity.Author;
import com.example.bookauthorrest.repository.AuthorRepository;
import com.example.bookauthorrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(int id) {
        return authorRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Optional<Author> findByEmail(String email) {
        return authorRepository.findByEmail(email);
    }

    @Override
    public boolean existsById(int id) {
        return authorRepository.existsById(id);
    }
}
