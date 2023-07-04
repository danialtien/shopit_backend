package com.danialtien.shopit.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GeneralService<T> {

    List<T> getAll();

    T add(T object);

    T getById(int id);

    T update(int id, T object);

    void remove(T object);

}
