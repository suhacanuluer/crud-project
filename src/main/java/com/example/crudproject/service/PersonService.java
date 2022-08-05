package com.example.crudproject.service;

import com.example.crudproject.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto save(PersonDto personDto);
    void delete(Long id);

    PersonDto update(PersonDto personDto);

    List<PersonDto> getAll();
    PersonDto get(Long id);
    PersonDto update(Long id, PersonDto personDto);
}
