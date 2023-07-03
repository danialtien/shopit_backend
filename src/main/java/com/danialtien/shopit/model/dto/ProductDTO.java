package com.danialtien.shopit.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Integer id;
    private Integer categoryId;
    private String productName;
    private Byte status;
    private Integer unitInStock;
    private BigDecimal unitPrice;
    private String urlImage;
    private String description;
}
