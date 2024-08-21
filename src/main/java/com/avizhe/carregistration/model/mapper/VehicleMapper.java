package com.avizhe.carregistration.model.mapper;


import com.avizhe.carregistration.model.dto.VehicleDto;
import com.avizhe.carregistration.model.entity.Person;
import com.avizhe.carregistration.model.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface VehicleMapper extends BaseConverter<Vehicle, VehicleDto>{

    @Override
    @Mapping(source = "person.id", target = "personId")
    VehicleDto convertEntity(Vehicle vehicle);

    @Override
    @Mapping(source = "personId", target = "person" ,qualifiedByName = "mapPersonIdToPerson")
    Vehicle convertDto(VehicleDto vehicleDto);


    @Named("mapPersonIdToPerson")
    default Person mapPersonIdToPerson(String personId) {
        if (personId == null) {
            return null;
        }
        Person person = new Person();
        person.setId(personId);
        return person;
    }
}
