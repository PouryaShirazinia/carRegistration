package com.mahan.carregistration.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    private String brand;
    @Column(unique = true, length = 8)
    @Pattern(regexp = "^.{8}$", message = "LICENSE_CODE_INVALID")
    private String licenseCode;
}
