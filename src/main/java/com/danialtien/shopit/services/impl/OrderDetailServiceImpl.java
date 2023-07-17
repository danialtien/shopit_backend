package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.OrderDetail;
import com.danialtien.shopit.repository.OrderdetailRepository;
import com.danialtien.shopit.repository.ProductRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailServiceImpl implements GeneralService<OrderDetail> {

    @Autowired
    private OrderdetailRepository repository;

    @Autowired
    private ProductRepository productRepository;
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

    public Optional<OrderDetail> updateDetail(int id, OrderDetail object) {
        Optional<OrderDetail> details = repository.findById(id);
        if (details != null) {
            if(object.getQuantity() == 0){
                repository.delete(object);
                return null;
            }

            details.get().setQuantity(object.getQuantity());
            details.get().setTotal(new BigDecimal(details.get().getQuantity()).multiply( details.get().getPrice()));
        }
        return details;
    }

    @Override
    public void remove(OrderDetail object) {
        repository.delete(object);
    }

    public List<OrderDetail> getAllOrderDetailByOrderId(int orderId) {
        List<OrderDetail> lists = repository.getByOrderId(orderId);

        return lists;
    }

    public void removeById(int id) {
        repository.delete(repository.getReferenceById(id));
    }

}
