package com.ecommerce.admin.products.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
public class ProductController {

    @PostMapping("/add")
    private void addProduct(){}

    @PostMapping("/")
    private void getProducts(){}

    @PostMapping("/modify/{id}")
    private void modifyProduct(){}

    @PostMapping("/delete/{id}")
    private void deleteProduct(){}

}
