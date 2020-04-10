package com.task.eCommerce.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Order")
public class Order {
    @Id
    private String orderId;
    private String itemCode;
    private String emailId;
    private Integer quantity;
    private Long price;
}
