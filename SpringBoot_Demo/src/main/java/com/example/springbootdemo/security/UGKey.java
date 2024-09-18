package com.example.springbootdemo.security;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable

public class UGKey implements Serializable {
    private String username;
    private String groupname;

    public UGKey() {
    }

    public UGKey(String username, String groupname) {
        this.username = username;
        this.groupname = groupname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    
}
