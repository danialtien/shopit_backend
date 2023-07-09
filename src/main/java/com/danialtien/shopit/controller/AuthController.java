package com.danialtien.shopit.controller;


import com.danialtien.shopit.model.dto.UserLogin;
import com.danialtien.shopit.model.entity.Customer;
import com.danialtien.shopit.services.impl.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class AuthController {

    @Autowired
    public final CustomerServiceImpl service;

    @PostMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody UserLogin loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Customer customer = service.login(email, password);
        if (customer != null) {
            // Successful authentication
            return ResponseEntity.ok().body(customer);
        } else {
            // Invalid credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody UserLogin loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        Customer customer = service.register(email, password);
        if (customer != null) {
            // Successful authentication
            return ResponseEntity.ok().body(customer);
        } else {
            // Invalid credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}

