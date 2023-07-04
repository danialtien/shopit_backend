package com.danialtien.shopit.repository;

import com.danialtien.shopit.model.entity.Shop;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ShopRepository extends JpaRepository<Shop, Integer> {

}