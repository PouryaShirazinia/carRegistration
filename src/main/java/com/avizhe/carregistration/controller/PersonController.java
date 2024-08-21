package com.avizhe.carregistration.controller;

import com.avizhe.carregistration.exeption.ServiceException;
import com.avizhe.carregistration.model.dto.PersonDto;
import com.avizhe.carregistration.model.entity.Person;
import com.avizhe.carregistration.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/person")
@RestController
public class PersonController extends AbstractController<Person, PersonDto, PersonService>{


    @PostMapping
    public PersonDto insert(@RequestBody PersonDto personDto) throws ServiceException {

      return converter.convertEntity(service.insert(converter.convertDto(personDto)));

    }


    @PutMapping
    public PersonDto update(@RequestBody Person person) throws ServiceException {

        return converter.convertEntity(service.update(person));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        service.delete(id);
    }

    @PostMapping("/example/{ascending}")
    public List<PersonDto> getAllByExample(@PathVariable boolean ascending, @RequestParam String sortBy, @RequestBody Person person){

        return converter.convertEntity(service.findAll(person, sortBy, ascending));
    }

}
