package com.ecommerce.admin.products.repository;

import com.ecommerce.admin.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByStatus(String status);
    Optional<Product> findByIdAndStatus(String id, String status);
}
