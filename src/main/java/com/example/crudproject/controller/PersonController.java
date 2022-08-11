package com.example.crudproject.controller;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.exception.EntityNotFoundException;
import com.example.crudproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> add(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.create(personDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(personService.getById(id));
        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("/city") // requestparam kullanıldı.
    public ResponseEntity<List<PersonDto>> getByCity(@RequestParam String city) {
        try {
            return ResponseEntity.ok(personService.getByCity(city));
        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @RequestBody PersonDto personDto) {
        try {
            return ResponseEntity.ok((personService.update(id, personDto)));
        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException(exception.getMessage());
        }
    }

    @DeleteMapping("/{id}")  // review iste olması gerektiği gibi mi
    public ResponseEntity delete(@PathVariable Long id) {
            personService.delete(id);
            return ResponseEntity.ok().build();

            // TODO: if service is throw exception, should not use catch.
            //  because thrown exception here is catching and needs against throw
            //  if the service is not throw exception,
            //  use the catch block and throw exception here.
            /*try {
            } catch (EntityNotFoundException exception) {
                throw new EntityNotFoundException(exception.getMessage());
            }*/
    }

}
