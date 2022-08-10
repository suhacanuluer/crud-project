package com.example.crudproject.service;

import com.example.crudproject.dto.TodoDto;
import org.springframework.stereotype.Service;

@Service
public interface TodoService {

    TodoDto create(Long personId, TodoDto todoDto);
    void complete(Long id);
    TodoDto update(Long id, TodoDto todoDto);
}
