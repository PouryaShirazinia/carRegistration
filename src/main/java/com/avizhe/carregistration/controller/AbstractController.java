package com.avizhe.carregistration.controller;


import com.avizhe.carregistration.model.entity.AbstractEntity;
import com.avizhe.carregistration.model.mapper.BaseConverter;
import com.avizhe.carregistration.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractController<E extends AbstractEntity, D, S extends AbstractService<E , ? extends JpaRepository<E, String>>> {

    @Autowired
    protected S service;
    @Autowired
    protected BaseConverter<E,D> converter;



}
