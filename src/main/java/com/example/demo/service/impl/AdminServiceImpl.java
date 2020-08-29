package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LoginUsersRepository;
import com.example.demo.entry.LoginUser;
import com.example.demo.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private LoginUsersRepository loginUsersRepository;
	
	
	public List<LoginUser> findByUserStatus(Boolean userStatus){
		
		return loginUsersRepository.findByUserStatus(userStatus);
		
	}
	
	public LoginUser findById(String id) {
		
		return loginUsersRepository.findById(id).orElse(null);
		
	}
	

	public void save(LoginUser loginUser) {
		
		loginUsersRepository.save(loginUser);
	}
}
