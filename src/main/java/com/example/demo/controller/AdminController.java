package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.constant.ViewConstant;
import com.example.demo.entry.LoginUser;
import com.example.demo.entry.UserRole;
import com.example.demo.service.AdminService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: zhh
 * @description: 管理员控制器
 * @data: 2020-08-29
 **/
@Slf4j
@Controller
public class AdminController extends BaseController{

	@Autowired
	private AdminService adminService;
	
	/*
	 * 首页
	 */
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.setAttribute("user", user);
		
		List<LoginUser> loginUsers = adminService.findByUserStatus(true);
		
		request.setAttribute("loginUsers", loginUsers);
		
		return ViewConstant.ADMIN_VIEW_INDEX;

	}
	
	/*
	 * 编辑用户
	 */
	@RequestMapping(value = "/admin/editUser", method = RequestMethod.GET)
	public String editUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		
		LoginUser loginUser = adminService.findById(userId);
		
		if(loginUser != null)
			request.setAttribute("loginUser", loginUser);
		
		return ViewConstant.ADMIN_VIEW_EDITUSER;

	}
	
	/*
	 * 更新用户
	 */
	@RequestMapping(value = "/admin/updateUser", method = RequestMethod.POST)
	public String updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		
		LoginUser loginUser = adminService.findById(userId);
		
		if(loginUser == null)
			return this.redirect(request,response,"用户不存在",ViewConstant.ADMIN_URL_EDITUSER + "?userId=" + userId);
		
		if(loginUser != null)
			request.setAttribute("loginUser", loginUser);
		
		
		loginUser.setUserName(userName);
		
		if(passwd != null && passwd != "") {
			
			if(passwd2 != null && passwd2 != "") {
				
				if(passwd.equals(passwd2)) {
					
					loginUser.setUserPasswd(passwd);
				}else {
					
					return this.redirect(request,response,"密码输入不一致",ViewConstant.ADMIN_URL_EDITUSER + "?userId=" + userId);
				}
			}else {
				
				return this.redirect(request,response,"确认密码不能为空",ViewConstant.ADMIN_URL_EDITUSER + "?userId=" + userId);
			}
		}
		
		
		if(passwd2 != null && passwd2 != "") {
			
			if(passwd != null && passwd != "") {
				
				if(passwd.equals(passwd2)) {
					
					loginUser.setUserPasswd(passwd);	
				}else {
					
					return this.redirect(request,response,"密码输入不一致",ViewConstant.ADMIN_URL_EDITUSER + "?userId="+userId);
				}
			}else {
				
				return this.redirect(request,response,"密码不能为空",ViewConstant.ADMIN_URL_EDITUSER + "?userId="+userId);
			}
		}
		
		
		adminService.save(loginUser);
		
		return this.redirect(request,response,"修改成功",ViewConstant.ADMIN_URL_INDEX);


	}
	
	/*
	 * 增加用户
	 */
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return ViewConstant.ADMIN_VIEW_ADDUSER;

	}
	
	/*
	 * 保存用户
	 */
	@RequestMapping(value = "/admin/saveUser", method = RequestMethod.POST)
	public String saveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String passwd2 = request.getParameter("passwd2");
		String userRole = request.getParameter("userRole");
		
		LoginUser loginUser = adminService.findById(userId);
		
		if(loginUser != null) {
			return this.redirect(request,response,"用户已存在",ViewConstant.ADMIN_URL_ADDUSER);
		}

		loginUser = new LoginUser();
		loginUser.setUserId(userId);
		loginUser.setUserName(userName);
		loginUser.setUserRole(UserRole.valueOf(userRole));
		

		if(passwd.equals(passwd2)) {
			
			loginUser.setUserPasswd(passwd);
			
		}else {
			
			return this.redirect(request,response,"密码输入不一致",ViewConstant.ADMIN_URL_ADDUSER);
		}
		

		
		adminService.save(loginUser);
		
		return this.redirect(request,response,"添加成功",ViewConstant.ADMIN_URL_INDEX);


	}
	
	/*
	 * 删除用户
	 */
	@RequestMapping(value = "/admin/delUser", method = RequestMethod.POST)
	public String delUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		
		LoginUser loginUser = adminService.findById(userId);
		
		if(loginUser == null) {
			return this.redirect(request,response,"用户不存在",ViewConstant.ADMIN_URL_INDEX);
		}
		
		loginUser.setUserStatus(false);
		
		adminService.save(loginUser);
		
		return this.redirect(request,response,"删除成功",ViewConstant.ADMIN_URL_INDEX);


	}
}