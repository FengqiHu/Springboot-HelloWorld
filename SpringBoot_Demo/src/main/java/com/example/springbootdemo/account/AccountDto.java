package com.example.springbootdemo.account;

import java.util.Set;

public record AccountDto(String username, String password, String email, Set<String> groups) {}
