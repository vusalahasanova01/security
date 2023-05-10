package com.example.userlogin.service;

import com.example.demo._2a.tables.records.UsersRecord;
import com.example.userlogin.repository.UserRepository;
import com.example.userlogin.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersRecord userByEmail = userRepository.findByEmail(email);
        return JwtUserDetails.create(userByEmail);
    }

    public UserDetails loadUserById(Long id) {
        UsersRecord userById = userRepository.findById(id);
        return JwtUserDetails.create(userById);
    }
}
