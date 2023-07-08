package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.Product;
import com.danialtien.shopit.services.impl.ProductServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private final ProductServiceImpl service;

    public ProductController() {
        this.service = new ProductServiceImpl();
    }

    @RequestMapping( value = "", method = RequestMethod.POST )
    @ApiOperation( value = "Create new Product" )
    public ResponseEntity<Product> savePublisher(@RequestBody Product object) {
        Product response = service.add(object);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "get all product", response = Product.class, responseContainer = "List" )
    public ResponseEntity<List<Product>> getAllCustomer() {
        List<Product> responses = service.getAll();
        if ( !responses.isEmpty() ) {
            return new ResponseEntity(responses, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    @ApiOperation( value = "Get Product Details By Id", response = Product.class )
    public ResponseEntity<List<Product>> getProduct(@RequestParam("id") int id) {
        Product response = service.getById(id);
        if ( response != null ) {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    @ApiOperation( value = "Update Product", response = Product.class )
    public ResponseEntity<Product> updateCustomer(@RequestParam("id") int id, @RequestBody Product dto) {
        Product reponse = service.update(id, dto);
        if(reponse != null){
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/")
    @ApiOperation( value = "Delete Product" )
    public ResponseEntity<HttpStatus> deleteCustomer(@RequestParam("id") int id) {
        service.removeByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
