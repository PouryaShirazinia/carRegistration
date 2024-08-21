package com.avizhe.carregistration.service;

import com.avizhe.carregistration.exeption.ServiceException;
import com.avizhe.carregistration.model.entity.Person;
import com.avizhe.carregistration.model.entity.Vehicle;
import com.avizhe.carregistration.repository.VehicleRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends AbstractService<Vehicle, VehicleRepository>{

    private final PersonService personService;

    public VehicleService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Vehicle insert(@Valid Vehicle vehicle) throws ServiceException {
        Person person = personService.getById(vehicle.getPerson().getId());
        try{
            vehicle.setPerson(person);
            return super.insert(vehicle);
        } catch (DataIntegrityViolationException ex) {
            throw new ServiceException("VEHICLE_UNIQUE_FIELD");
        }
    }

    @Override
    public Vehicle update(@Valid Vehicle vehicle) throws ServiceException {
        try {
            return insert(vehicle);
        }catch (ObjectOptimisticLockingFailureException exception){
            throw new ServiceException("Row_updated_by_another_transaction");
        }
    }



}
