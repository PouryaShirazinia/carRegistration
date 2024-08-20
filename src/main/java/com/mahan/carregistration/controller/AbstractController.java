package com.mahan.carregistration.controller;


import com.mahan.carregistration.model.entity.AbstractEntity;
import com.mahan.carregistration.model.mapper.BaseConverter;
import com.mahan.carregistration.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractController<E extends AbstractEntity,D, S extends AbstractService<E , ? extends JpaRepository<E, String>>> {

    @Autowired
    protected S service;
    @Autowired
    protected BaseConverter<E,D> converter;



}
