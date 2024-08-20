package com.mahan.carregistration.model.mapper;


import com.mahan.carregistration.model.dto.PersonDto;
import com.mahan.carregistration.model.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends BaseConverter<Person, PersonDto>{

}
