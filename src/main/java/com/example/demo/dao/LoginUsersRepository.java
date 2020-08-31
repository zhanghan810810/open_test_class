package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entry.LoginUser;

/**
 * @author: zhh
 * @description: 用户dao
 * @data: 2020-08-29
 **/
public interface LoginUsersRepository extends JpaRepository<LoginUser,String>{

	public List<LoginUser> findByUserStatus(Boolean userStatus);
}
