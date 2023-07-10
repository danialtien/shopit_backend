package com.danialtien.shopit.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Data
@Table(name = "shop")
public class Shop implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private boolean status;
}