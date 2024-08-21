package com.avizhe.carregistration.repository;

import com.avizhe.carregistration.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {
}
