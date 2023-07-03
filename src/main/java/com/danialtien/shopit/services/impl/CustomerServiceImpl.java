package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Customer;
import com.danialtien.shopit.repository.CustomerRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements GeneralService<Customer> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer add(Customer object) {
        return repository.save(object);
    }

    @Override
    public Customer getById(int id) {
        Customer customer = repository.getReferenceById(id);
        return customer;
    }

    @Override
    public Customer update(Customer object) {
        return null;
    }

    @Override
    public void remove(Customer object) {
        repository.delete(object);
    }
}
