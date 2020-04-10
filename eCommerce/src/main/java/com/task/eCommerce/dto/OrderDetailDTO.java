package com.task.eCommerce.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    private String itemCode;
    private String emailId;
    private Integer quantity;
}
