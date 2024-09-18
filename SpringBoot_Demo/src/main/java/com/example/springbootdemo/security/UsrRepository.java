package com.example.springbootdemo.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrRepository extends JpaRepository<Usr, String> {

}
