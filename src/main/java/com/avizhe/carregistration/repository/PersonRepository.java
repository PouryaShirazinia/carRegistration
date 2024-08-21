package com.avizhe.carregistration.repository;

import com.avizhe.carregistration.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {


}
