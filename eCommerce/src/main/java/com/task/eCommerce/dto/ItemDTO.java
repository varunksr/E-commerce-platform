package com.task.eCommerce.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private String itemCode;
    private String itemName;
    private Long price;
    private Integer inStock;
}
