package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.constant.ViewConstant;
import com.example.demo.entry.UserRole;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: zhh
 * @description: 首页控制器
 * @data: 2020-08-29
 **/
@Slf4j
@Controller
public class IndexController extends BaseController{

	
	/**
	 * @description 首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.setAttribute("user", user);

		for(GrantedAuthority authority : user.getAuthorities()) {
			
			if(authority.getAuthority().contains(UserRole.ADMIN.toString()))
				return this.redirect(request,response,ViewConstant.ADMIN_URL_INDEX);
			else if(authority.getAuthority().contains(UserRole.STUDENT.toString()))
				return this.redirect(request,response,ViewConstant.STUDENT_URL_INDEX);
			else if(authority.getAuthority().contains(UserRole.TEACHER.toString()))
				return this.redirect(request,response,ViewConstant.TEACHER_URL_INDEX);
		}

		throw new RuntimeException("用户角色错误");

	}
	
}