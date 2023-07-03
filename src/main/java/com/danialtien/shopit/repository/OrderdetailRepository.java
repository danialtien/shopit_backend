package com.danialtien.shopit.repository;

import com.danialtien.shopit.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderdetailRepository extends JpaRepository<OrderDetail, Integer> {
}