package com.example.crudproject.controller;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.ok(personService.save(personDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> get(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(personService.get(id));
        } catch (RuntimeException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll() {
        return ResponseEntity.ok(personService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @RequestBody PersonDto personDto) {
        try {
            return ResponseEntity.ok((personService.update(id, personDto)));
        } catch (RuntimeException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")  // review iste olması gerektiği gibi mi
    public ResponseEntity delete(@PathVariable Long id) {
            try {
                personService.delete(id);
                return ResponseEntity.ok().build();
            } catch (RuntimeException exception) {
                return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
            }
    }

}
