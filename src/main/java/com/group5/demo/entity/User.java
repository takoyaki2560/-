package com.group5.demo.entity;

import java.util.UUID;

public class User {
    public String _id;
    public String name;
    public String password;
    public String role;

    public User() {
    }

    public User(String name, String password, String role) {
        this._id = UUID.randomUUID().toString().replaceAll("-","");
        this.name = name;
        this.password = password;
        System.out.println(password.length());
        this.role = role;
    }
}
