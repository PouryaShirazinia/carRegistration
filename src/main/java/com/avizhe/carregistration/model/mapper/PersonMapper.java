package com.avizhe.carregistration.model.mapper;


import com.avizhe.carregistration.model.dto.PersonDto;
import com.avizhe.carregistration.model.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper extends BaseConverter<Person, PersonDto>{

}
