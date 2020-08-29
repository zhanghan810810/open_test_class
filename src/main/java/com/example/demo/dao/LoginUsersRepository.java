package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entry.LoginUser;

public interface LoginUsersRepository extends JpaRepository<LoginUser,String>{

	public List<LoginUser> findByUserStatus(Boolean userStatus);
}
