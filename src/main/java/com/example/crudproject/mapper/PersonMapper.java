package com.example.crudproject.mapper;

import com.example.crudproject.dto.PersonDto;
import com.example.crudproject.entity.PersonEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

// null gelirse eski veriyi tutuyor
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
// Strategy for propagating the value of
// collection-typed properties from source to target.
//https://mapstruct.org/documentation/1.0/api/org/mapstruct/CollectionMappingStrategy.html
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)

public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonEntity personDtoToPersonEntity(PersonDto personDto);
    PersonDto personEntityToPersonDto(PersonEntity personEntity);
    void updatePersonFromDto(PersonDto newPersonDto, @MappingTarget PersonEntity oldPersonEntity);
}
