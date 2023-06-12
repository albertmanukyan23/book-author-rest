package com.example.bookauthorrest.mapper;

import com.example.bookauthorrest.dto.CreateUserRequestDto;
import com.example.bookauthorrest.dto.UserDto;
import com.example.bookauthorrest.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User map(CreateUserRequestDto dto);

    UserDto mapToDto(User entity);
}
