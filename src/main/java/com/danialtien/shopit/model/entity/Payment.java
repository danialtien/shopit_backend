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
@Table(name = "payment")
public class Payment  implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payment_method")
    private String paymentMethod;
}
