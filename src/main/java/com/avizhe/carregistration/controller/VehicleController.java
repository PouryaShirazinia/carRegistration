package com.avizhe.carregistration.controller;

import com.avizhe.carregistration.exeption.ServiceException;
import com.avizhe.carregistration.model.dto.PersonDto;
import com.avizhe.carregistration.model.dto.VehicleDto;
import com.avizhe.carregistration.model.entity.Person;
import com.avizhe.carregistration.model.entity.Vehicle;
import com.avizhe.carregistration.service.VehicleService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vehicle")
@RestController
public class VehicleController extends AbstractController<Vehicle, VehicleDto, VehicleService>{


    @PostMapping
    public VehicleDto insert(@RequestBody VehicleDto vehicleDto) throws ServiceException {

     return converter.convertEntity(service.insert(converter.convertDto(vehicleDto)));

    }


    @PutMapping
    public VehicleDto update(@RequestBody Vehicle vehicle) throws ServiceException {

        return converter.convertEntity(service.update(vehicle));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws ServiceException {
        service.delete(id);
    }


    @PostMapping("/example/{ascending}")
    public List<VehicleDto> getAllByExample(@PathVariable boolean ascending, @RequestParam String sortBy, @RequestBody Vehicle vehicle){

        return converter.convertEntity(service.findAll(vehicle, sortBy, ascending));
    }

}
