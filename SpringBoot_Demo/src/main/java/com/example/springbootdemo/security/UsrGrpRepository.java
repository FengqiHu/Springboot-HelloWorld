package com.example.springbootdemo.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsrGrpRepository extends JpaRepository<UsrGrp, UGKey> {
    @Query("SELECT u FROM UsrGrp u WHERE u.ugKey.username = ?1")
    List<UsrGrp> findByUsername(String username);
}
