package com.mahan.carregistration.controller;

import com.mahan.carregistration.exeption.ServiceException;
import com.mahan.carregistration.model.dto.PersonDto;
import com.mahan.carregistration.model.dto.VehicleDto;
import com.mahan.carregistration.model.entity.Person;
import com.mahan.carregistration.model.entity.Vehicle;
import com.mahan.carregistration.service.PersonService;
import com.mahan.carregistration.service.VehicleService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vehicle")
@RestController
public class VehicleController extends AbstractController<Vehicle, VehicleDto, VehicleService>{


    @PostMapping
    public VehicleDto insert(@RequestBody VehicleDto vehicleDto) throws ServiceException {

     return converter.convertEntity(service.insert(converter.convertDto(vehicleDto)));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        service.delete(id);
    }
}
