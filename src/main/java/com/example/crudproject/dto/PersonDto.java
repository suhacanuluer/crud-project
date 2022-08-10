package com.example.crudproject.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private String city;
    private Boolean isStudent;
    private List<TodoDto> todos;

}
