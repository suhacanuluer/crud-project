package com.example.crudproject.mapper;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // null gelirse eski veriyi tutuyor
public interface PersonMapper {
    PersonEntity personDtoToPersonEntity(PersonDto personDto);
    PersonDto personEntityToPersonDto(PersonEntity personEntity);
    void updatePersonFromDto(PersonDto newPersonDto, @MappingTarget PersonEntity oldPersonEntity);
}
