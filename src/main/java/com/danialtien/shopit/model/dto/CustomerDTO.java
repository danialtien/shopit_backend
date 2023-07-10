package com.danialtien.shopit.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class CustomerDTO {
//    private Integer id;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String avatar;
    private String address;
    private LocalDateTime createdAt;
    private boolean status;
}
