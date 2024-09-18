package com.example.springbootdemo.security;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;

@Entity
public class UsrGrp {
    @EmbeddedId
    private UGKey ugKey;
    private Date createdAt;

    public UsrGrp() {
    }

    public UsrGrp(UGKey ugKey) {
        this.ugKey = ugKey;
    }

    public UGKey getUgKey() {
        return ugKey;
    }

    public void setUgKey(UGKey ugKey) {
        this.ugKey = ugKey;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    private void setCreatedAt() {
        this.createdAt = new Date();
    }

}