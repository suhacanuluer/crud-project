package com.example.crudproject.service.impl;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.entity.PersonEntity;
import com.example.crudproject.exception.EntityNotFoundException;
import com.example.crudproject.mapper.PersonMapper;
import com.example.crudproject.repository.PersonRepository;
import com.example.crudproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public PersonDto create(PersonDto personDto) {
        PersonEntity personEntity = personRepository.save(PersonMapper.INSTANCE.personDtoToPersonEntity(personDto));
        return PersonMapper.INSTANCE.personEntityToPersonDto(personEntity);
    }

    @Override
    public PersonDto getById(Long id) {
        return personRepository.findById(id)
                .map(PersonMapper.INSTANCE::personEntityToPersonDto)
        // Stream#map stream içindeki yığınsal olarak bulunan her bir veriyi dönüştürmeye olanak tanır.
        // Dönüştürüm işlemi Stream içerisindeki her bir öğe için ayrı ayrı yapılmaktadır.
        // Stream#map metodu Function türünden bir parametre beklemektedir.
                .orElseThrow(() -> new EntityNotFoundException("id:" + id + " not found"));
    }

    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll().stream()
                .map(PersonMapper.INSTANCE::personEntityToPersonDto)
                .collect(Collectors.toList()); // stream to list dönüşümü
        // Stream#collect metodu Collector türünden bir parametre kabul etmektedir.
        // Bu parametre ile istendik türe dönüşüm sağlanmaktadır.
        // Collector türünden arayüzler, Collectors sınıfının çeşitli statik metodlarıyla elde edilebilmektedir.
    }

    @Override
    public PersonDto update(Long id, PersonDto newPersonDto) {
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id:" + id + " not found"));

        PersonMapper.INSTANCE.updatePersonFromDto(newPersonDto, personEntity);
        personRepository.save(personEntity);

        return PersonMapper.INSTANCE.personEntityToPersonDto(personEntity);
    }

    @Override
    public void delete(Long id) {
        PersonEntity personEntity = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id:" + id + " not found"));
        personRepository.delete(personEntity);
    }

    @Override
    public List<PersonDto> getByCity(String city) {
        return personRepository.findByCity(city).stream()
                .map(PersonMapper.INSTANCE::personEntityToPersonDto)
                .collect(Collectors.toList());
    }

}
