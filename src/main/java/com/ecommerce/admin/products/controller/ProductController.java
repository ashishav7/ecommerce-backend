package com.ecommerce.admin.products.controller;

import com.ecommerce.admin.products.dto.AddProductRequest;
import com.ecommerce.admin.products.dto.AddProductResponse;
import com.ecommerce.admin.products.mappers.ProductMapper;
import com.ecommerce.admin.products.service.ProductService;
import com.ecommerce.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/add")
    private AddProductResponse addProduct(@RequestBody AddProductRequest addProductRequest){
        AddProductResponse response = ProductMapper.toResponse(null);
        try {
            response = ProductMapper.toResponse(productService.addProduct(addProductRequest));
            response.setStatus(String.valueOf(HttpStatus.OK));
            response.setMessage("Successfully Created Product");
            response.setMessageCode(Constants.SUCCESS);
        }catch (Exception e){
            response.setMessageCode(Constants.FAIL);
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST.toString());
        }
        return response;
    }

    @PostMapping("/")
    private void getProducts(){}

    @PostMapping("/modify/{id}")
    private void modifyProduct(){}

    @PostMapping("/delete/{id}")
    private void deleteProduct(){}

}
