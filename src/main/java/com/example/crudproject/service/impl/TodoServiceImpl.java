package com.example.crudproject.service.impl;

import com.example.crudproject.dto.TodoDto;
import com.example.crudproject.entity.PersonEntity;
import com.example.crudproject.entity.TodoEntity;
import com.example.crudproject.exception.EntityNotFoundException;
import com.example.crudproject.mapper.PersonMapper;
import com.example.crudproject.mapper.TodoMapper;
import com.example.crudproject.repository.TodoRepository;
import com.example.crudproject.service.PersonService;
import com.example.crudproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final PersonService personService;

    @Override
    public TodoDto create(Long id, TodoDto todoDto) {
        PersonEntity personEntity = PersonMapper.INSTANCE.personDtoToPersonEntity(personService.getById(id));
        TodoEntity todoEntity = TodoMapper.INSTANCE.todoDtoToTodoEntity(todoDto);
        personEntity.getTodos().add(todoEntity);
        todoEntity.setPerson(personEntity);
        return TodoMapper.INSTANCE.todoEntityToTodoDto(todoRepository.save(todoEntity));
    }

    @Override
    public void complete(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id:" + id + " not found"));
        todoEntity.setIsCompleted(true);
        todoRepository.save(todoEntity);
    }

    @Override
    public TodoDto update(Long id, TodoDto newTodoDto) {
        TodoEntity todoEntity = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("id:" + id + " not found"));

        TodoMapper.INSTANCE.updateTodoFromDto(newTodoDto, todoEntity);
        todoRepository.save(todoEntity);

        return TodoMapper.INSTANCE.todoEntityToTodoDto(todoEntity);
    }
}
