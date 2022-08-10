package com.example.crudproject.mapper;

import com.example.crudproject.dto.TodoDto;
import com.example.crudproject.entity.TodoEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    TodoEntity todoDtoToTodoEntity(TodoDto todoDto);
    TodoDto todoEntityToTodoDto(TodoEntity todoEntity);
    void updateTodoFromDto(TodoDto newTodoDto, @MappingTarget TodoEntity oldTodoEntity);
}
