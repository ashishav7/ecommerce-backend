package com.ecommerce.admin.products.service;

import com.ecommerce.admin.products.dto.AddProductRequest;
import com.ecommerce.admin.products.model.Product;

public interface ProductService {

    public Product addProduct(AddProductRequest addProductRequest);

}
