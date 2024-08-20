package com.mahan.carregistration.service;

import com.mahan.carregistration.exeption.ServiceException;
import com.mahan.carregistration.model.entity.Person;
import com.mahan.carregistration.model.entity.Vehicle;
import com.mahan.carregistration.repository.VehicleRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class
VehicleService extends AbstractService<Vehicle, VehicleRepository>{

    private final PersonService personService;

    public VehicleService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Vehicle insert(@Valid Vehicle vehicle) throws ServiceException {

        Person person = personService.getById(vehicle.getPerson().getId());
        vehicle.setPerson(person);
        return super.insert(vehicle);
    }
}
