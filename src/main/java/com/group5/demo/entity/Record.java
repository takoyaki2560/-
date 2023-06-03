package com.group5.demo.entity;

public class Record {
    public String pId ;
    public String tId ;
    public int salePrice ;
    public int amount ;

    public Record(String pId, String tId, int salePrice, int amount) {
        this.pId = pId;
        this.tId = tId;
        this.salePrice = salePrice;
        this.amount = amount;
    }

    public Record() {
    }
}
