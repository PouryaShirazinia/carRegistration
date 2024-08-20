package com.mahan.carregistration.service;


import com.mahan.carregistration.exeption.ServiceException;
import com.mahan.carregistration.model.entity.AbstractEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public abstract class AbstractService<E extends AbstractEntity,  R extends JpaRepository<E , String>>{

    @Autowired
    protected R repository;

    public E insert(@Valid E e) throws ServiceException {
        return repository.save(e);
    }

    public E update(@Valid E e) throws ServiceException {
        return repository.save(e);
    }

    public void delete(String id) throws ServiceException {

        repository.deleteById(id);
    }

    public List<E> findAll(E e ){

        Sort sort = true ? Sort.by("sortBy").ascending() : Sort.by("sortBy").descending();

        return repository.findAll(Example.of(e, ExampleMatcher.matchingAll()) ,Sort.by("sortBy").ascending());
    }

}
