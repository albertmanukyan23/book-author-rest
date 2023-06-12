package com.example.bookauthorrest.mapper;

import com.example.bookauthorrest.dto.AuthorDto;
import com.example.bookauthorrest.dto.CreateAuthorRequestDto;
import com.example.bookauthorrest.dto.CreateAuthorResponseDto;
import com.example.bookauthorrest.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author map(CreateAuthorRequestDto dto);
    CreateAuthorResponseDto map(Author entity);
    AuthorDto mapToDto(Author entity);
}
