package com.example.crudproject.service.impl;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.entity.PersonEntity;
import com.example.crudproject.mapper.PersonMapper;
import com.example.crudproject.repository.PersonRepository;
import com.example.crudproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

    @Override
    public PersonDto save(PersonDto personDto) {
        PersonEntity personEntity = personRepository.save(personMapper.personDtoToPersonEntity(personDto));
        return personMapper.personEntityToPersonDto(personEntity);
    }

    @Override
    public PersonDto get(Long id) {
        return personRepository.findById(id)
                .map(personEntity -> personMapper.personEntityToPersonDto(personEntity))
                .orElseThrow(() -> new NoSuchElementException(id + ": not found"));
    }

    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll().stream()
                .map(personEntity -> personMapper.personEntityToPersonDto(personEntity))
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto update(Long id, PersonDto newPersonDto) {
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(id + ": not found"));

        personMapper.updatePersonFromDto(newPersonDto, personEntity);
        personRepository.save(personEntity);

        return personMapper.personEntityToPersonDto(personEntity);
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
                .map(personEntity -> personMapper.personEntityToPersonDto(personEntity))
                .collect(Collectors.toList()); // incele anlamaya calıs
    }

}
