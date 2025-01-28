package com.ecommerce.admin.products.service;

import com.ecommerce.admin.products.dto.AddProductRequest;
import com.ecommerce.admin.products.model.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(AddProductRequest addProductRequest);
    public List<Product> getProducts();

    public Product updateProduct(String id,AddProductRequest addProductRequest);

    public Product deleteProduct(String id);

    public Product getProductById(String id);

}
