package com.danialtien.shopit.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PaymentDTO {
    private Integer id;
    private Integer orderId;
    private LocalDate paymentDate;
    private BigDecimal amount;
    private String paymentMethod;
}
