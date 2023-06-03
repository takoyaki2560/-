package com.group5.demo.controller;

import com.group5.demo.entity.Product;
import com.group5.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Product")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public Product add(@RequestBody Product product){
        Product newProduct =  new Product(product.category,product.pName,product.pPackage,product.saleCount,product.price);
        service.insert(newProduct);
        return  newProduct;
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin')")
    public List<Product> findAll(){
        return service.findAll();
    }
}