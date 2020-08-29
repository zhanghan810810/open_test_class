package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entry.LoginUser;

public interface AdminService {

	public List<LoginUser> findByUserStatus(Boolean userStatus);
	public LoginUser findById(String id);
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void save(LoginUser loginUser);
}
