package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.OrderDetail;
import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.model.entity.Product;
import com.danialtien.shopit.services.impl.OrderDetailServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @ApiOperation(value = "Get Order Details By Order ID", response = Product.class)
    public ResponseEntity<List<OrderDetail>> getOrderDetailsByOrderId(@RequestParam("orderId") int orderId) {
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetailByOrderId(orderId);
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
    @PutMapping("/update")
    @ApiOperation( value = "Update Order detail", response = OrderDetail.class )
    public ResponseEntity<OrderDetail> updateOrderDetail(@RequestParam("id") int id, @RequestBody OrderDetail dto) {
        Optional<OrderDetail> response = orderDetailService.updateDetail(id, dto);
        if(response.get() != null && response != null){
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
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
