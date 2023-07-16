package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.services.impl.OrderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private final OrderServiceImpl orderService;
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }
    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "Get all order", response = Orders.class, responseContainer = "List" )
    public ResponseEntity<List<Orders>> getAllOrder() {
        List<Orders> listOrders = orderService.getAll();
        if (!listOrders.isEmpty()) {
            return new ResponseEntity(listOrders, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping( value = "", method = RequestMethod.POST )
    @ApiOperation( value = "Create new order")
    public ResponseEntity<Orders> createOrder (@RequestBody Orders orders) {
        Orders responses = orderService.add(orders);
        return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }
    @RequestMapping( value = "/getOrdersByOrderId", method = RequestMethod.GET )
    @ApiOperation( value = "Get Orders By Id", response = Orders.class )
    public ResponseEntity<List<Orders>> getOrdersById(@RequestParam("id") int id) {
        Orders response = orderService.getById(id);
        if ( response != null ) {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/getOrdersByCustomerId", method = RequestMethod.GET)
    @ApiOperation(value = "Get Orders By Customer Id", response = List.class)
    public ResponseEntity<Orders> getOrdersByCustomerId(@RequestParam("customerId") int customerId) {
        Orders response = orderService.getOrderByCustomerId(customerId);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/")
    @ApiOperation( value = "Update Order", response = Orders.class)
    public ResponseEntity<Orders> updateOrder(@RequestParam("id") int id, @RequestBody Orders dto) {
        Orders response = orderService.update(id, dto);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/")
    @ApiOperation( value = "Delete Orders" )
    public ResponseEntity<HttpStatus> deleteOrders(@RequestParam("id") int id) {
        orderService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
