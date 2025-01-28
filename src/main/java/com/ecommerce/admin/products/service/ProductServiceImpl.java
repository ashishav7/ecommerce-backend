package com.ecommerce.admin.products.service;

import com.ecommerce.admin.products.dto.AddProductRequest;
import com.ecommerce.admin.products.mappers.ProductMapper;
import com.ecommerce.admin.products.model.Product;
import com.ecommerce.admin.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public Product addProduct(AddProductRequest addProductRequest) {
        Product product = ProductMapper.toEntity(addProductRequest);
        return productRepository.save(product);
    }
}
