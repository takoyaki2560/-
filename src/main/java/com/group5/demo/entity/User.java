package com.group5.demo.entity;

import java.util.UUID;

public class User {
    public String _id;
    public String name;
    public String password;
    public String role;
    public String Address;
    public String phone;
    public String email;

    public User() {
    }

    public User(String name, String password, String role, String address, String phone, String email) {
        this._id = UUID.randomUUID().toString().replaceAll("-","");
        this.name = name;
        this.password = password;
        this.role = role;
        this.Address = address;
        this.phone = phone;
        this.email = email;
    }
}
