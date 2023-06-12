package com.example.bookauthorrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorRequestDto {
    private String name;
    private String surname;
    private String email;
}
