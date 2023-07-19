package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.OrderDetail;
import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.repository.OrderdetailRepository;
import com.danialtien.shopit.repository.OrdersRepository;
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
    private OrderdetailRepository orderdetailRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<OrderDetail> getAll() {
        return orderdetailRepository.findAll();
    }

    @Override
    public OrderDetail add(OrderDetail object) {
        object.setTotal(BigDecimal.valueOf(object.getQuantity()).multiply(object.getPrice()));
        OrderDetail dto = orderdetailRepository.save(object);
        if (dto != null) {
            updateOrderTotalPrice(ordersRepository.findById(dto.getOrderId()));
        }
        return dto;
    }

    public void updateOrderTotalPrice(Optional<Orders> object) {
        BigDecimal total = BigDecimal.valueOf(0);
        if (object != null) {
            List<OrderDetail> orderDetailList = orderdetailRepository.findAll().stream().filter(x -> x.getOrderId() == object.get().getId()).toList();
            for (OrderDetail dto : orderDetailList) {
                total = total.add(dto.getTotal());
            }
            Optional<Orders> orders = ordersRepository.findById(object.get().getId());
            if (orders != null) {
                orders.get().setTotalPrice(total);
                ordersRepository.save(orders.get());
            }

        }
    }

    @Override
    public OrderDetail getById(int id) {
        return orderdetailRepository.getReferenceById(id);
    }

    @Override
    public OrderDetail update(int id, OrderDetail object) {
        return null;
    }

    public Optional<OrderDetail> updateDetail(int id, OrderDetail object) {
        Optional<OrderDetail> details = orderdetailRepository.findById(id);

        if (details != null) {
            int orderId = details.get().getOrderId();
            if (object.getQuantity() == 0) {
                orderdetailRepository.delete(object);
                updateOrderTotalPrice(ordersRepository.findById(orderId));
                return null;
            }
            details.get().setQuantity(object.getQuantity());
            details.get().setTotal(new BigDecimal(details.get().getQuantity()).multiply(details.get().getPrice()));
            updateOrderTotalPrice(ordersRepository.findById(orderId));
        }
        return details;
    }

    @Override
    public void remove(OrderDetail object) {
        int orderId = object.getOrderId();
        orderdetailRepository.delete(object);
        updateOrderTotalPrice(ordersRepository.findById(orderId));
    }

    public List<OrderDetail> getAllOrderDetailByOrderId(int orderId) {
        List<OrderDetail> lists = orderdetailRepository.getByOrderId(orderId);
        return lists;
    }

    public void removeById(int id) {
        int orderId = orderdetailRepository.findById(id).get().getOrderId();
        orderdetailRepository.delete(orderdetailRepository.getReferenceById(id));
        updateOrderTotalPrice(ordersRepository.findById(orderId));
    }
}
