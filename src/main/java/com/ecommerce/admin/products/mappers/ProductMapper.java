package com.ecommerce.admin.products.mappers;

import com.ecommerce.admin.products.dto.AddProductRequest;
import com.ecommerce.admin.products.dto.AddProductResponse;
import com.ecommerce.admin.products.model.Product;
import com.ecommerce.common.Constants;

import java.util.Date;

public class ProductMapper {

    public static Product toEntity(AddProductRequest productRequest){
        if(productRequest == null){
            return null;
        }
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setCategory(productRequest.getCategory());
        product.setCostPrice(Long.parseLong(productRequest.getCostPrice()));
        product.setSellingPrice(Long.parseLong(productRequest.getSellingPrice()));
        product.setQuantity(Long.parseLong(productRequest.getQuantity()));
        product.setImage(productRequest.getImage());
        product.setStatus(Constants.Y);
        product.setCreatedBy("ROOT");
        product.setModifiedOn(new Date());
        return product;
    }

    public static AddProductResponse toResponse(Product product){
        if(product == null){
            return AddProductResponse.builder().build();
        }
        return AddProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .quantity(product.getQuantity().toString())
                .build();
    }
}
