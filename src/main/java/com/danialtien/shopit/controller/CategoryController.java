package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.Category;
import com.danialtien.shopit.model.entity.Product;
import com.danialtien.shopit.services.impl.CategoryServiceImpl;
import com.danialtien.shopit.services.impl.ProductServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private final CategoryServiceImpl service;

    @Autowired
    private final ProductServiceImpl productService;

    public CategoryController() {
        this.service = new CategoryServiceImpl();
        this.productService = new ProductServiceImpl();
    }

    @RequestMapping( value = "", method = RequestMethod.POST )
    @ApiOperation( value = "Create new category" )
    public ResponseEntity<Category> savePublisher(@RequestBody Category object) {
        Category response = service.add(object);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "get all category", response = Category.class, responseContainer = "List" )
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> responses = service.getAll();
        if ( !responses.isEmpty() ) {
            return new ResponseEntity(responses, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping( value = "/id", method = RequestMethod.GET )
    @ApiOperation( value = "Get Category Details By Id", response = Category.class )
    public ResponseEntity<List<Category>> getCategory(@RequestParam("id") int id) {
        Category response = service.getById(id);
        if ( response != null ) {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping( value = "/{id}/products", method = RequestMethod.GET )
    @ApiOperation( value = "get all product by Category ID", response = Category.class, responseContainer = "List" )
    public ResponseEntity<List<Product>> getAllProductByCategoryID(@RequestParam("id") int categoryId) {
        List<Product> responses = productService.getByCategoryId(categoryId);
        if ( !responses.isEmpty() ) {
            return new ResponseEntity(responses, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
