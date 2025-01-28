package com.ecommerce.admin.products.service;

import com.ecommerce.admin.products.dto.AddProductRequest;
import com.ecommerce.admin.products.mappers.ProductMapper;
import com.ecommerce.admin.products.model.Product;
import com.ecommerce.admin.products.repository.ProductRepository;
import com.ecommerce.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        product.setCreatedBy("ROOT");
        product.setCreatedOn(new Date());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findByStatus(Constants.Y);
    }

    @Override
    public Product updateProduct(String id, AddProductRequest addProductRequest) {
        Optional<Product> product1 = productRepository.findByIdAndStatus(id,Constants.Y);
        Product product;
        if(product1.isPresent()){
            product = product1.get();
            product = ProductMapper.toEntity(addProductRequest);
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product deleteProduct(String id) {
        Optional<Product> product1 = productRepository.findByIdAndStatus(id,Constants.Y);
        Product product;
        if (product1.isPresent()) {
            product = product1.get();
            product.setStatus(Constants.N);
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public Product getProductById(String id) {
        Optional<Product> product1 = productRepository.findByIdAndStatus(id,Constants.Y);
        Product product;
        if (product1.isPresent()) {
            product = product1.get();
            return product;
        }
        return null;
    }
}
