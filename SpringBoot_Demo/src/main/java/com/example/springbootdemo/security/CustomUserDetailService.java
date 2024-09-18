package com.example.springbootdemo.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsrRepository usrRepository;
    @Autowired
    private UsrGrpRepository usrGrpRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usr> optionalUsr = usrRepository.findById(username);

        if (optionalUsr.isPresent()) {
            List<UsrGrp> usrGrps = usrGrpRepository.findByUsername(username);
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (UsrGrp usrGrp : usrGrps) {
                GrantedAuthority authority = new SimpleGrantedAuthority(usrGrp.getUgKey().getGroupname());
                authorities.add(authority);
            }
            return new User(optionalUsr.get().getUsername(), optionalUsr.get().getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

}
