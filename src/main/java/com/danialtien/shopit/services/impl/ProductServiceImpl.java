package com.danialtien.shopit.services.impl;

import com.danialtien.shopit.model.entity.Customer;
import com.danialtien.shopit.model.entity.Product;
import com.danialtien.shopit.repository.CategoryRepository;
import com.danialtien.shopit.repository.ProductRepository;
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
public class ProductServiceImpl implements GeneralService<Product> {

    @Autowired
    private ProductRepository repository;


    @Autowired
    private CategoryRepository categoryRepository;

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
    public Product update(int id, Product object) {
        Product dto = repository.getReferenceById(id);
        if(dto != null){
            dto.setCategoryId(object.getCategoryId());
            dto.setDescription(object.getDescription());
            dto.setUrlImage(object.getUrlImage());
            dto.setProductName(object.getProductName());
            dto.setUnitPrice(object.getUnitPrice());
            dto.setUnitInStock(object.getUnitInStock());
            dto.setProductName(object.getProductName());
            return dto;
        }
        return null;
    }

    @Override
    public void remove(Product object) {

    }

    public void removeByID(Integer id) {
        repository.delete(repository.getReferenceById(id));
    }

    public List<Product> getByCategoryId(int id) {
        List<Product> product = new ArrayList<>();
        if(categoryRepository.findById(id).isPresent()){
            product = repository.findByCategoryId(id);
        }
        return product;
    }
}
