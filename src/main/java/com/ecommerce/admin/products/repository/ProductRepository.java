package com.ecommerce.admin.products.repository;

import com.ecommerce.admin.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
