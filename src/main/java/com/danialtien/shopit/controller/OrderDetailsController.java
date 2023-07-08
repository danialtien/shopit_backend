package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.OrderDetail;
import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.model.entity.Product;
import com.danialtien.shopit.services.impl.OrderDetailServiceImpl;
import io.swagger.annotations.ApiOperation;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order_details")
public class OrderDetailsController {
    @Autowired
    private final OrderDetailServiceImpl orderDetailService;
    public OrderDetailsController(OrderDetailServiceImpl orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "Get all order details", response = OrderDetail.class, responseContainer = "List" )
    public ResponseEntity<List<Orders>> getAllOrder() {
        List<OrderDetail> listOrderDetails = orderDetailService.getAll();
        if (!listOrderDetails.isEmpty()) {
            return new ResponseEntity(listOrderDetails, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/getOrderDetailsByOrderId", method = RequestMethod.GET)
    @ApiOperation(value = "Get Order Details By Order ID", response = OrderDetail.class)
    public ResponseEntity<List<OrderDetail>> getOrderDetailsByOrderId(@RequestParam("orderId") int orderId) {
        List<OrderDetail> orderDetails = orderDetailService.getByOrderId(orderId);
        if (!orderDetails.isEmpty()) {
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping( value = "", method = RequestMethod.POST )
    @ApiOperation( value = "Create new order details" )
    public ResponseEntity<OrderDetail> createOrderDetails(@RequestBody OrderDetail orderDetail) {
        OrderDetail response = orderDetailService.add(orderDetail);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ApiOperation( value = "Update Product", response = Product.class )
    public ResponseEntity<OrderDetail> updateCustomer(@RequestParam("id") int id, @RequestBody OrderDetail dto) {
        OrderDetail response = orderDetailService.update(id, dto);
        if(response != null){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/")
    @ApiOperation( value = "Delete Orders Detail" )
    public ResponseEntity<HttpStatus> deleteOrdersDetails(@RequestParam("id") int id) {
        orderDetailService.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
