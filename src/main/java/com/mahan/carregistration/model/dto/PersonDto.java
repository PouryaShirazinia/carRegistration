package com.mahan.carregistration.model.dto;

import com.mahan.carregistration.model.entity.AbstractEntity;
import com.mahan.carregistration.model.entity.Vehicle;
import jakarta.persistence.Version;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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
    private List<VehicleDto> vehicle;

}
