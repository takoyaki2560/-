package com.group5.demo.entity;

import java.sql.Timestamp;
import java.util.UUID;

public class Transaction {
    public String tId ;
    public String mId ;
    public Timestamp transTime ;

    public Transaction(String mId, Timestamp transTime) {
        this.tId = UUID.randomUUID().toString().replaceAll("-","");
        this.mId = mId;
        this.transTime = transTime;
    }

    public Transaction() {
    }
}
