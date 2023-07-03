package com.danialtien.shopit.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrdersDTO {
    private Integer id;
    private Integer customerId;
    private LocalDate orderDate;
    private String shippingAddress;
    private BigDecimal totalPrice;
    private String status;

}
