package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Category;
import com.danialtien.shopit.repository.CategoryRepository;
import com.danialtien.shopit.services.GeneralService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class CategoryServiceImpl implements GeneralService<Category> {

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category add(Category object) {
        return repository.save(object);
    }

    @Override
    public Category getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Category update(int id, Category object) {
        return null;
    }

    @Override
    public void remove(Category object) {
        repository.delete(object);
    }
}
