package com.ecommerce.admin.products.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private String quantity;
    private String sellingPrice;
    private String costPrice;
    private String image;
    private String createdOn;
    private String createdBy;
    private String modifiedOn;
    private String modifiedBy;
}
