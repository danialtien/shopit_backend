package com.danialtien.shopit.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "product")
public class Product  implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "status")
    private String status;

    @Column(name = "unit_in_stock")
    private Integer unitInStock;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "url_image")
    private String urlImage;

    @Column(name = "description")
    private String description;
}