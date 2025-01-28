package com.ecommerce.admin.products.dto;

import com.ecommerce.admin.products.model.Product;
import com.ecommerce.common.response.BaseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductResponse extends BaseResponse {
    List<Product> products;
}
