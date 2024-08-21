package com.avizhe.carregistration.model.dto;

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
