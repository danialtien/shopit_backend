package com.danialtien.shopit.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderdetailDTO {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal total;

}
