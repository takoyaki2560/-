package com.group5.demo.entity;

import java.util.UUID;

public class Transaction {
    public String tId ;
    public String mId ;
    public long transTime ;

    public Transaction(String mId, long transTime) {
        this.tId = UUID.randomUUID().toString().replaceAll("-","");
        this.mId = mId;
        this.transTime = transTime;
    }
}
