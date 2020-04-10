package com.task.eCommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    private List<OrderDetailDTO> orderDetailDTOS;
    private Long totalPrice;
    private String status;
}
