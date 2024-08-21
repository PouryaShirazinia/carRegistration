package com.avizhe.carregistration.controller;

import com.avizhe.carregistration.exeption.ServiceException;
import com.avizhe.carregistration.model.dto.VehicleDto;
import com.avizhe.carregistration.model.entity.Vehicle;
import com.avizhe.carregistration.service.VehicleService;
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
