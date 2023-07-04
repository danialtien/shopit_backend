package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.OrderDetail;
import com.danialtien.shopit.repository.OrderdetailRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements GeneralService<OrderDetail> {

    @Autowired
    private OrderdetailRepository repository;
    @Override
    public List<OrderDetail> getAll() {
        return repository.findAll();
    }

    @Override
    public OrderDetail add(OrderDetail object) {
        return repository.save(object);
    }

    @Override
    public OrderDetail getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public OrderDetail update(OrderDetail object) {
        return null;
    }

    @Override
    public void remove(OrderDetail object) {
        repository.delete(object);
    }
}
