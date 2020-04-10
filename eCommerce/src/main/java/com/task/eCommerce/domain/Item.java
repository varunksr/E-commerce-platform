package com.task.eCommerce.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Item")
public class Item {
    @Id
    private String itemId;
    @Column(unique = true)
    private String itemCode;
    private String itemName;
    private Long price;
    private Integer inStock;
}
