package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.OrderDetail;
import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.repository.OrderdetailRepository;
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
    public OrderDetail update(int id, OrderDetail object) {
        return null;
    }

    @Override
    public void remove(OrderDetail object) {
        repository.delete(object);
    }

    public List<OrderDetail> getByOrderId(int orderId) {
        List<OrderDetail> lists = new ArrayList<>();
        for (OrderDetail orderDetail : repository.findAll()) {
            if (orderDetail.getOrderId() == orderId) {
                lists.add(orderDetail);
            }
        }
        return lists;
    }

    public void removeById(int id) {
        repository.delete(repository.getReferenceById(id));
    }

}
