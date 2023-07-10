package com.danialtien.shopit.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name = "product")
public class Product  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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