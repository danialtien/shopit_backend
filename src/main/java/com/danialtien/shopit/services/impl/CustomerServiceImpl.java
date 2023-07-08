package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Customer;
import com.danialtien.shopit.repository.CustomerRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
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
    public Customer update(int customerId, Customer object) {
        Customer customer = repository.getReferenceById(customerId);
        if(customer != null){
            customer.setAddress(object.getAddress());
            customer.setAvatar(object.getAvatar());
            customer.setPhone(object.getPhone());
            customer.setFullName(object.getFullName());
            customer.setEmail(object.getEmail());
            customer.setPassword(object.getPassword());
            return customer;
        }
        return null;
    }

    @Override
    public void remove(Customer object) {
        repository.delete(object);
    }
    public Customer softRemove(Integer customerId) {
        Customer customer = repository.getReferenceById(customerId);
        if (customer != null) {
            customer.setStatus(false);
            return customer;
        }
        return null;
    }
}
