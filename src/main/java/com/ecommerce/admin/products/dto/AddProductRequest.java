package com.ecommerce.admin.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddProductRequest {
    private String name;
    private String description;
    private String category;
    private String subCategory;
    private String quantity;
    private String sellingPrice;
    private String costPrice;
    private String image;
}
