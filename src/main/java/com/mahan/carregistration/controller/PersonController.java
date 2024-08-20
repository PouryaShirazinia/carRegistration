package com.mahan.carregistration.controller;

import com.mahan.carregistration.exeption.ServiceException;
import com.mahan.carregistration.model.dto.PersonDto;
import com.mahan.carregistration.model.entity.Person;
import com.mahan.carregistration.model.entity.Vehicle;
import com.mahan.carregistration.service.PersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController extends AbstractController<Person, PersonDto, PersonService>{


    @PostMapping
    public PersonDto insert(@RequestBody PersonDto person) throws ServiceException {

      return converter.convertEntity(service.insert(converter.convertDto(person)));

    }


    @PutMapping
    public PersonDto update(@RequestBody Person person) throws ServiceException {

        return converter.convertEntity(service.update(person));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        service.delete(id);
    }

    @PostMapping("/example")
    public List<PersonDto> getAllByExample(@RequestBody Person person){

        return converter.convertEntity(service.findAll(person));
    }

}
