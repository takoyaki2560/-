package com.group5.demo.entity;

import java.util.UUID;

public class Product {
    public String pid ;
    public String category ;
    public String pName ;
    public String pPackage ;
    public int saleCount ;
    public int price ;

    public Product(String category, String pName, String pPackage, int saleCount, int price) {
        this.pid = UUID.randomUUID().toString().replaceAll("-","");
        this.category = category;
        this.pName = pName;
        this.pPackage = pPackage;
        this.saleCount = saleCount;
        this.price = price;
    }

    public Product() {
    }
}
