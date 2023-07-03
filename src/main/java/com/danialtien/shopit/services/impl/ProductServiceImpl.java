package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Product;
import com.danialtien.shopit.repository.ProductRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements GeneralService<Product> {
    private ProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product add(Product object) {
        return repository.save(object);
    }

    @Override
    public Product getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Product update(Product object) {
        return null;
    }

    @Override
    public void remove(Product object) {
        repository.delete(object);
    }
}
