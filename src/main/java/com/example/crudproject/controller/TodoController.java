package com.example.crudproject.controller;

import com.example.crudproject.dto.TodoDto;
import com.example.crudproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/{id}")
    public ResponseEntity<TodoDto> add(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(todoService.create(id, todoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> update(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        try {
            return ResponseEntity.ok(todoService.update(id, todoDto));
        } catch (RuntimeException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity complete(@PathVariable Long id) {
        try {
            todoService.complete(id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException exception) {
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
