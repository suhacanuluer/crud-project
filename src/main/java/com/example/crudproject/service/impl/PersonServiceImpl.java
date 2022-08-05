package com.example.crudproject.service.impl;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.entity.PersonEntity;
import com.example.crudproject.repository.PersonRepository;
import com.example.crudproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonDto save(PersonDto personDto) {
        PersonEntity personEntity = personRepository.save(PersonEntity.of(personDto));
        return PersonDto.of(personEntity);
    }

    @Override
    public PersonDto get(Long id) {
        return personRepository.findById(id)
                .map(PersonDto::of)
                .orElseThrow(() -> new NoSuchElementException(id + ": not found"));
    }

    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll().stream()
                .map(PersonDto::of)
                .toList();
    }

    @Override
    public PersonDto update(Long id, PersonDto newPersonDto) {
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id + ": not found"));

        // mapping kullanılacak
        personEntity.setName(newPersonDto.getName());
        personEntity.setSurname(newPersonDto.getSurname());
        personEntity.setAge(newPersonDto.getAge());
        personEntity.setCity(newPersonDto.getCity());
        personEntity.setIsStudent(newPersonDto.getIsStudent());

        return PersonDto.of(personEntity);
    }

    @Override
    public void delete(Long id) {
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + ": not found"));
        personRepository.delete(personEntity);
    }

    @Override
    public List<PersonDto> getByCity(String city) {
        return personRepository.findByCity(city).stream()
                .map(PersonDto::of)
                .toList();
    }

}
