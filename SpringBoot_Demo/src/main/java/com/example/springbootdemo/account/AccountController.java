package com.example.springbootdemo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody AccountDto accountDto) {
        if (accountService.createAccount(accountDto) != null) {
            return ResponseEntity.created(null).body("注册成功");
        } else {
            return ResponseEntity.badRequest().body("注册失败");
        }
    }

    @GetMapping
    public ResponseEntity<String> testGet() {
        return ResponseEntity.ok("GET ACCOUNTS OK!");
    }

    @GetMapping("/id/{username}")
    public ResponseEntity<String> findByUsername(@PathVariable("username") String username) {
        // ...
        return ResponseEntity.ok("User Found!" + username);
    }

    @GetMapping("/admins")
    public ResponseEntity<String> admins() {
        return ResponseEntity.ok("ADMINS RESOURCES!<br/><a href='/logout'>Logout</a>");
    }

    @GetMapping("/employees")
    public ResponseEntity<String> employees() {
        return ResponseEntity.ok("EMPLOYEES RESOURCES!");
    }

}
