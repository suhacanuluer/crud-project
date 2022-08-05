package com.example.crudproject.dto;

import com.example.crudproject.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private String city;
    private Boolean isStudent;

    public static PersonDto of(PersonEntity personEntity) {
        return new PersonDto(personEntity.getId(),
                personEntity.getName(),
                personEntity.getSurname(),
                personEntity.getAge(),
                personEntity.getCity(),
                personEntity.getIsStudent());
    }
}
