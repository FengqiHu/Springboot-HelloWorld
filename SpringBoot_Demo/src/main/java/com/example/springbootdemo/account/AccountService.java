package com.example.springbootdemo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springbootdemo.security.UGKey;
import com.example.springbootdemo.security.Usr;
import com.example.springbootdemo.security.UsrGrp;
import com.example.springbootdemo.security.UsrGrpRepository;
import com.example.springbootdemo.security.UsrRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UsrRepository usrRepository;
    @Autowired
    private UsrGrpRepository usrGrpRepository;
    @Autowired  
    private BCryptPasswordEncoder passwordEncoder; 

    public Account getAccount(String accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    public Account createAccount(AccountDto accountDto) {
        if (getAccount(accountDto.username()) != null) {
            return null;
        } else {
            String pwdSecrete = passwordEncoder.encode(accountDto.password());
            Account account = new Account(accountDto.username(), accountDto.email());
            Usr usr = new Usr(accountDto.username(), pwdSecrete, accountDto.email());
            accountRepository.save(account);
            usrRepository.save(usr);

            for (String groupname : accountDto.groups()) {
                UGKey ugKey = new UGKey(accountDto.username(), groupname);
                UsrGrp usrGrp = new UsrGrp(ugKey);
                usrGrpRepository.save(usrGrp);
            }
            return account;
        }

    }

    public Account updateAccount(AccountDto accountDto) {
        Account account = new Account();
        return accountRepository.save(account);
    }

    public void deleteAccount(String accountId) {
        accountRepository.deleteById(accountId);
    }

}
