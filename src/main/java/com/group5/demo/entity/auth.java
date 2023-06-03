package com.group5.demo.entity;

import org.springframework.security.core.GrantedAuthority;

public class auth implements GrantedAuthority {
    private String authority;

    public auth(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
