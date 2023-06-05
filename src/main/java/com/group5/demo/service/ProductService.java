package com.group5.demo.service;

import com.group5.demo.entity.Product;
import com.group5.demo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper mapper;

    public Integer insert (Product product){
        return mapper.insert(product);
    }

    public Product findByName (String name){
        return mapper.findProductByName(name);
    }
    public List<Product> findAll(){
        return mapper.findAllProducts();
    }

    public  Product findNameByID(String id){
        System.out.println(id);
        return  mapper.findById(id);
    }
}
