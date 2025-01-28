package com.ecommerce.admin.products.controller;

import com.ecommerce.admin.products.dto.AddProductRequest;
import com.ecommerce.admin.products.dto.AddProductResponse;
import com.ecommerce.admin.products.dto.ProductResponse;
import com.ecommerce.admin.products.mappers.ProductMapper;
import com.ecommerce.admin.products.model.Product;
import com.ecommerce.admin.products.service.ProductService;
import com.ecommerce.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/add")
    private ResponseEntity<AddProductResponse> addProduct(@RequestBody AddProductRequest addProductRequest){
        AddProductResponse response = ProductMapper.toResponse(null);
        try {
            response = ProductMapper.toResponse(productService.addProduct(addProductRequest));
            response.setStatus(String.valueOf(HttpStatus.OK));
            response.setMessage("Successfully Created Product");
            response.setMessageCode(Constants.SUCCESS);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.setMessageCode(Constants.FAIL);
            response.setMessage(e.getMessage());
            response.setStatus(HttpStatus.BAD_REQUEST.toString());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/")
    private ResponseEntity<ProductResponse> getProducts(){
        ProductResponse response = new ProductResponse();
        try {
            List<Product> products = productService.getProducts();
            response.setProducts(products);
            response.setStatus(Constants.SUCCESS);
            response.setMessage(Constants.SUCCESS);
            response.setMessageCode(Constants.SUCCESS);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.setStatus(Constants.FAIL);
            response.setMessage(Constants.FAIL);
            response.setMessageCode(Constants.FAIL);
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/modify/{id}")
    private void modifyProduct(@PathVariable String id,@RequestBody AddProductRequest updateProductRequest){
        productService.updateProduct(id,updateProductRequest);
    }

    @PostMapping("/delete/{id}")
    private void deleteProduct(@PathVariable String id){
        productService.deleteProduct(id);
    }

}
