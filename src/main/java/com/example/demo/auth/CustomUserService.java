package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginUsersRepository;
import com.example.demo.entry.LoginUser;

/**
 * @author: zhh
 * @description: 客户化登录逻辑
 * @data: 2020-08-29
 **/
@Service
public class CustomUserService implements UserDetailsService { 
    
	@Autowired
	private LoginUsersRepository loginUsersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        
    	LoginUser loginUser = loginUsersRepository.findById(username).orElse(null);
    	if(loginUser == null || !loginUser.getUserStatus())
    		throw new UsernameNotFoundException(username); 

    	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	
    	UserDetails user = User
                .withUsername(username)
                .password(passwordEncoder.encode(loginUser.getUserPasswd()))
                .roles(loginUser.getUserRole().toString())
                .build();
    	
    	return user;
    }
}