package com.mahan.carregistration.repository;

import com.mahan.carregistration.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {


}
