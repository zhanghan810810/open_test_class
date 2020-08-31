package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhh
 * @description 控制器基类
 * @data 2020-08-29
 **/
public class BaseController {

	/**
	 * @description 提示&重定向
	 * @param request
	 * @param response
	 * @param alertMsg 提示信息
	 * @param redirectUrl 重定向地址
	 * @return
	 */
	protected String redirect(HttpServletRequest request, HttpServletResponse response,String alertMsg,String redirectUrl) {
		
		if(alertMsg != null) 
			request.setAttribute("alertMsg", alertMsg);
		
		request.setAttribute("redirectUrl", redirectUrl);
		return "alert";
	}
	
	/**
	 * @description 重定向
	 * @param request
	 * @param response
	 * @param redirectUrl 重定向地址
	 * @return
	 */
	protected String redirect(HttpServletRequest request, HttpServletResponse response,String redirectUrl) {
		 
		return redirect(request,response,null,redirectUrl);
	}
}
