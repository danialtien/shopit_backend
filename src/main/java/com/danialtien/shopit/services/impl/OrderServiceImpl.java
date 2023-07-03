package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.repository.OrdersRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements GeneralService<Orders> {
    private OrdersRepository repository;
    @Override
    public List<Orders> getAll() {
        return repository.findAll();
    }

    @Override
    public Orders add(Orders object) {
        return repository.save(object);
    }

    @Override
    public Orders getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Orders update(Orders object) {
        return null;
    }

    @Override
    public void remove(Orders object) {
        repository.delete(object);
    }
}
