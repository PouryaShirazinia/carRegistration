package com.avizhe.carregistration.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person extends AbstractEntity {


    private String firstName;
    private String lastName;
    @Column(unique = true, length = 10 )
    @Pattern(regexp = "^\\d{10}$" , message = "NATIONAL_ID_LENGTH")
    private String nationalId;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles;

}
