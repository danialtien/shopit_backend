package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Shop;
import com.danialtien.shopit.repository.ShopRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ShopServiceImpl implements GeneralService<Shop> {
    private ShopRepository repository;
    @Override
    public List<Shop> getAll() {
        return repository.findAll();
    }

    @Override
    public Shop add(Shop object) {
        return repository.save(object);
    }

    @Override
    public Shop getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Shop update(Shop object) {
        return null;
    }

    @Override
    public void remove(Shop object) {
        repository.delete(object);
    }
}
