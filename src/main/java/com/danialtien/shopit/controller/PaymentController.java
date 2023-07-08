package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.Payment;
import com.danialtien.shopit.services.impl.PaymentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private final PaymentServiceImpl paymentService;

    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }
    @RequestMapping( value = "/all", method = RequestMethod.GET )
    @ApiOperation( value = "Get all payment", response = Payment.class, responseContainer = "List" )
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> lists = paymentService.getAll();
        if (!lists.isEmpty()) {
            return new ResponseEntity(lists, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping( value = "", method = RequestMethod.POST )
    @ApiOperation( value = "Create new payment")
    public ResponseEntity<Payment> createPayment (@RequestBody Payment payments) {
        Payment responses = paymentService.add(payments);
        return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }
    @RequestMapping( value = "/id", method = RequestMethod.GET )
    @ApiOperation( value = "Get Payment By Payment Id", response = Payment.class )
    public ResponseEntity<List<Payment>> getPaymentById(@RequestParam("id") int id) {
        Payment response = paymentService.getById(id);
        if ( response != null ) {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping( value = "/orderId", method = RequestMethod.GET )
    @ApiOperation( value = "Get Payment By Order Id", response = Payment.class )
    public ResponseEntity<List<Payment>> getPaymentByOrderId(@RequestParam("orderId") int orderId) {
        List<Payment> response = paymentService.getByOrderId(orderId);
        if ( response != null ) {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/")
    @ApiOperation( value = "Update Payment", response = Payment.class)
    public ResponseEntity<Payment> updatePayment(@RequestParam("id") int id, @RequestBody Payment dto){
        Payment response = paymentService.update(id, dto);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
