package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.repository.OrdersRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class OrderServiceImpl implements GeneralService<Orders> {

    @Autowired
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
    public Orders update(int id, Orders object) {
        return null;
    }

    @Override
    public void remove(Orders object) {
        repository.delete(object);
    }
    public Orders getOrderByCustomerId(int customerId) {
        List<Orders> listOrders = new ArrayList<>();
        for (Orders orders : repository.findAll()) {
            if (orders.getCustomerId() == customerId) {
                listOrders.add(orders);
            }
        }
        Orders orders = null;
        orders = (Orders) listOrders.stream().filter(x -> x.getStatus().equals("Pending"));
        return orders;
    }

    public void removeById(int id) {
        repository.delete(repository.getReferenceById(id));
    }
}
