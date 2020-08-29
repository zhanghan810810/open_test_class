package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: zhh
 * @description: 控制器基类
 * @data: 2020-08-29
 **/
public class BaseController {

	/*
	 * 提示&重定向
	 */
	protected String redirect(HttpServletRequest request, HttpServletResponse response,String alertMsg,String redirectUrl) {
		
		if(alertMsg != null) 
			request.setAttribute("alertMsg", alertMsg);
		
		request.setAttribute("redirectUrl", redirectUrl);
		return "alert";
	}
	
	/*
	 * 重定向
	 */
	protected String redirect(HttpServletRequest request, HttpServletResponse response,String redirectUrl) {
		
		return redirect(request,response,null,redirectUrl);
	}
}
