package com.ecommerce.admin.products.dto;

import com.ecommerce.admin.products.model.Product;
import com.ecommerce.common.response.BaseResponse;

public class AddProductResponse extends BaseResponse {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private String quantity;
    private String sellingPrice;
    private String costPrice;
    private String image;
}
