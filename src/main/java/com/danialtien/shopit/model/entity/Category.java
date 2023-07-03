package com.danialtien.shopit.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "category_name")
    private String categoryName;
}
