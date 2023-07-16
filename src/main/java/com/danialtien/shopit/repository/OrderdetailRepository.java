package com.danialtien.shopit.repository;

import com.danialtien.shopit.model.entity.OrderDetail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface OrderdetailRepository extends JpaRepository<OrderDetail, Integer> {

    List<OrderDetail> getByOrderId(int id);
}