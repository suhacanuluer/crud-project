package com.example.crudproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}
