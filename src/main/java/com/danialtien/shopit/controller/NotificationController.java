package com.danialtien.shopit.controller;

import com.danialtien.shopit.model.entity.Notification;
import com.danialtien.shopit.model.entity.Orders;
import com.danialtien.shopit.model.entity.Payment;
import com.danialtien.shopit.services.impl.NotificationServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    private final NotificationServiceImpl notificationService;
    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }
    @RequestMapping(value = "/getNotificationByCustomerId", method = RequestMethod.GET)
    @ApiOperation(value = "Get Notification By Customer Id", response = List.class)
    public ResponseEntity<List<Notification>> getOrdersByCustomerId(@RequestParam("customerId") int customerId) {
        List<Notification> response = notificationService.getNotificationByCustomerId(customerId);
        if (!response.isEmpty()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping( value = "", method = RequestMethod.POST )
    @ApiOperation( value = "Create new notification")
    public ResponseEntity<Notification> createPayment (@RequestBody Notification payments) {
        Notification responses = notificationService.add(payments);
        return new ResponseEntity<>(responses, HttpStatus.CREATED);
    }
}

