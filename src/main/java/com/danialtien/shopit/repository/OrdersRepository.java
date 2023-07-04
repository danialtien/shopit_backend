package com.danialtien.shopit.repository;

import com.danialtien.shopit.model.entity.Orders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}