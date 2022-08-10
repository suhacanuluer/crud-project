package com.example.crudproject.service;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.entity.PersonEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    PersonDto create(PersonDto personDto);
    PersonDto getById(Long id);
    List<PersonDto> getAll();
    PersonDto update(Long id, PersonDto personDto);
    void delete(Long id);
    List<PersonDto> getByCity(String city);
}
