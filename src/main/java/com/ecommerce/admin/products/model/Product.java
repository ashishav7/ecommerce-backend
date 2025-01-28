package com.ecommerce.admin.products.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "custom-key-generator")
    @GenericGenerator(name = "custom-key-generator", strategy = "com.ecommerce.utility.generator.IdGenerator", parameters = {@org.hibernate.annotations.Parameter(name = "prefix", value = "PROD"), @org.hibernate.annotations.Parameter(name = "paddingLength", value = "10")})
    private String id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "selling_price")
    private Long sellingPrice;

    @Column(name = "cost_price")
    private Long costPrice;

    @Column(name = "product_image")
    private String image;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_on")
    private Date modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "status")
    private String status;
}