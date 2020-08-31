package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entry.LoginUser;

/**
 * @author: zhh
 * @description: 管理员service
 * @data: 2020-08-29
 **/
public interface AdminService {

	/**
	 * @description 查找用户
	 * @param userStatus 是否有效（true 有效 false 已删除）
	 * @return
	 */
	public List<LoginUser> findByUserStatus(Boolean userStatus);
	
	/**
	 * @description 通过用户名查找用户
	 * @param id 用户名
	 * @return
	 */
	public LoginUser findById(String id);
	
	
	/**
	 * @description 保存用户
	 * @param loginUser 用户信息
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED) 
	public void save(LoginUser loginUser);
}
