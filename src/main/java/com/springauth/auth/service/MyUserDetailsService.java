package com.springauth.auth.service;

import com.springauth.auth.dao.UserPrinciple;
import com.springauth.auth.dao.UserRepo;
import com.springauth.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
   @Autowired
   private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null){
            System.out.println("user not found: 404");
            throw new UsernameNotFoundException("User not found: 404");
        }
        return new UserPrinciple(user);
    }
}
