package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Payment;
import com.danialtien.shopit.repository.PaymentRepository;
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
public class PaymentServiceImpl implements GeneralService<Payment> {

    @Autowired
    private PaymentRepository repository;
    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }

    @Override
    public Payment add(Payment object) {
        return repository.save(object);
    }

    @Override
    public Payment getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Payment update(int id, Payment object) {
        return null;
    }

    @Override
    public void remove(Payment object) {
        repository.delete(object);
    }
}
