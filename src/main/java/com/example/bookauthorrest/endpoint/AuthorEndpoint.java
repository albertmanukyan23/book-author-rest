package com.example.bookauthorrest.endpoint;

import com.example.bookauthorrest.dto.AuthorDto;
import com.example.bookauthorrest.dto.CreateAuthorRequestDto;
import com.example.bookauthorrest.dto.CreateAuthorResponseDto;
import com.example.bookauthorrest.entity.Author;
import com.example.bookauthorrest.mapper.AuthorMapper;
import com.example.bookauthorrest.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorEndpoint {

    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    @PostMapping
    public ResponseEntity<CreateAuthorResponseDto> create(@RequestBody CreateAuthorRequestDto requestDto) {
        Optional<Author> byEmail = authorService.findByEmail(requestDto.getEmail());
        if (byEmail.isEmpty()) {
            Author author = authorMapper.map(requestDto);
            authorService.save(author);
            return ResponseEntity.ok(authorMapper.map(author));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAuthors() {
        List<Author> all = authorService.findAll();
        if (all.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<AuthorDto> authorDtos = new ArrayList<>();
        for (Author author : all) {
            authorDtos.add(authorMapper.mapToDto(author));
        }
        return ResponseEntity.ok(authorDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") int id) {
        Optional<Author> byId = authorService.findById(id);
        return byId.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable("id") int id, @RequestBody Author author) {
        Optional<Author> byId = authorService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Author> byEmail = authorService.findByEmail(author.getEmail());
        if (byEmail.isPresent() && byEmail.get().getId() != id) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Author authorFromDb = byId.get();
        if (author.getName() != null && !author.getName().isEmpty()) {
            authorFromDb.setName(author.getName());
        }
        if (author.getSurname() != null && !author.getSurname().isEmpty()) {
            authorFromDb.setSurname(author.getSurname());
        }
        if (author.getEmail() != null && !author.getEmail().isEmpty()) {
            authorFromDb.setEmail(author.getEmail());
        }
        return ResponseEntity.ok(authorService.save(authorFromDb));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") int id) {
        if (authorService.existsById(id)) {
            authorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
