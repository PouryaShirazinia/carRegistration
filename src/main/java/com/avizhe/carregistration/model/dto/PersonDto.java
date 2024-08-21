package com.avizhe.carregistration.model.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PersonDto {

    private String id;
    private Long version;
    private Date insertTimeStamp;
    private String firstName;
    private String lastName;
    private String nationalId;
    private List<VehicleDto> vehicleDtos;

}
