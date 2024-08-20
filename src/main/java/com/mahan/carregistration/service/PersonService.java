package com.mahan.carregistration.service;

import com.mahan.carregistration.exeption.ServiceException;
import com.mahan.carregistration.model.entity.Person;
import com.mahan.carregistration.repository.PersonRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class PersonService extends AbstractService<Person, PersonRepository>{

    @Override
    public Person insert(@Valid Person person) throws ServiceException {

        try {
          return  repository.save(person);

        }catch (DataIntegrityViolationException ex){
            throw new ServiceException("PERSON_UNIQUE_FIELD");
        }

    }

    @Override
    public Person update(@Valid Person person) throws ServiceException {

        try {
            return insert(person);
        }catch (ObjectOptimisticLockingFailureException exception){
            throw new ServiceException("Row_updated_by_another_transaction");
        }
    }


    @Override
    public void delete(String id) throws ServiceException {
        Person person = getById(id);

        if (person.getVehicle() == null || person.getVehicle().isEmpty()){
            super.delete(id);
        }else {
            throw new ServiceException("PERSON_HAS_VEHICLE");
        }
    }



    public Person getById(String id) throws ServiceException {

        return repository.findById(id)
                .orElseThrow(() -> new ServiceException("PERSON_NOT_FOUND"));
    }
}
