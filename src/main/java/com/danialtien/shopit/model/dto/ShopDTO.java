package com.danialtien.shopit.model.dto;

import lombok.Data;

@Data
public class ShopDTO {
    private Integer id;
    private String shopName;
    private String address;
    private String phone;
    private Byte status;
}
