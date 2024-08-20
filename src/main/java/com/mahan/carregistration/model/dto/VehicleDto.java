package com.mahan.carregistration.model.dto;

import com.mahan.carregistration.model.entity.Person;
import lombok.*;

import java.util.Date;

@Getter
@Setter
public class VehicleDto {

    private String id;
    private Long version;
    private Date insertTimeStamp;
    private String personId;
    private String brand;
    private String licenseCode;
}
