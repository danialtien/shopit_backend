package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.Customer;
import com.danialtien.shopit.services.impl.CustomerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private final CustomerServiceImpl service;

    public CustomerController() {
        this.service = new CustomerServiceImpl();
    }

    @RequestMapping( value = "", method = RequestMethod.POST )
    @ApiOperation( value = "Create new Customer" )
    public ResponseEntity<Customer> savePublisher(@RequestBody Customer customer) {
        Customer publisherResponse = service.add(customer);
        return new ResponseEntity<>(publisherResponse, HttpStatus.CREATED);
    }

    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "get all customers", response = Customer.class, responseContainer = "List" )
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = service.getAll();
        if ( !customers.isEmpty() ) {
            return new ResponseEntity(customers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    @ApiOperation( value = "get customer Details By Id", response = Customer.class )
    public ResponseEntity<List<Customer>> getCustomer(@RequestParam("id") int id) {
        Customer customer = service.getById(id);
        if ( customer != null ) {
            return new ResponseEntity(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/")
    @ApiOperation( value = "Update customer", response = Customer.class )
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId, @RequestBody Customer updatedCustomer) {
        Customer reponse = service.update(customerId, updatedCustomer);
        if(reponse != null){
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
