package com.group5.demo.entity;

import java.util.UUID;

public class Material {
    public String mId ;
    public String mType ;
    public String mName ;
    public String mNum ;

    public Material() {
    }

    public Material(String mType, String mName, String mNum) {
        this.mId = UUID.randomUUID().toString().replaceAll("-","");
        this.mType = mType;
        this.mName = mName;
        this.mNum = mNum;
    }

}
