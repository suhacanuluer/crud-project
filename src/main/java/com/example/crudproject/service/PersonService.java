package com.example.crudproject.service;

import com.example.crudproject.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto save(PersonDto personDto);
    PersonDto get(Long id);
    List<PersonDto> getAll();
    PersonDto update(Long id, PersonDto personDto);
    void delete(Long id);
}
