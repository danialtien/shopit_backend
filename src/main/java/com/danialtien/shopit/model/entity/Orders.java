package com.danialtien.shopit.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Table(name = "orders")
public class Orders  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "status")
    private String status;

}
