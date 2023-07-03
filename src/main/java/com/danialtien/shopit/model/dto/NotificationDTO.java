package com.danialtien.shopit.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDTO {
    private Integer id;
    private Integer customerId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}
