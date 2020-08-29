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
import com.example.demo.entry.Course;
import com.example.demo.entry.Subscribe;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.vo.student.FindCourseVo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: zhh
 * @description: 学生控制器
 * @data: 2020-08-29
 **/
@Slf4j
@Controller
public class StudentController extends BaseController{

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	/*
	 * 首页
	 */
	@RequestMapping(value = "/student/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.setAttribute("user", user);
		 
		List<FindCourseVo> courses = teacherService.findCoursesAndIsSubscribed(user.getUsername());
		
		request.setAttribute("courses", courses);
		
		return ViewConstant.STUDENT_VIEW_INDEX;

	}
	
	/*
	 * 订阅
	 */
	@RequestMapping(value = "/student/subscribe", method = RequestMethod.POST)
	public String subscribe(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String courseId = request.getParameter("courseId");
		
		Subscribe subscribe = studentService.findByCourseIdAndStudentId(courseId,user.getUsername());
		Course course = teacherService.findById(courseId);

		if(course == null)
			return this.redirect(request,response,"该课程信息不存在",ViewConstant.STUDENT_URL_INDEX);
		
		if(subscribe != null)
			return this.redirect(request,response,"已经订阅了该课程",ViewConstant.STUDENT_URL_INDEX);
		
		
		subscribe = new Subscribe();
		subscribe.setCourseId(courseId);
		subscribe.setStudentId(user.getUsername());
	
		studentService.subscribe(subscribe);
		
		return this.redirect(request,response,"订阅成功",ViewConstant.STUDENT_URL_INDEX);

	}
	
	/*
	 * 取消订阅
	 */
	@RequestMapping(value = "/student/unsubscribe", method = RequestMethod.POST)
	public String unsubscribe(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String courseId = request.getParameter("courseId");
		
		Subscribe subscribe = studentService.findByCourseIdAndStudentId(courseId,user.getUsername());
		Course course = teacherService.findById(courseId);
		
		if(course == null)
			return this.redirect(request,response,"该课程信息不存在",ViewConstant.STUDENT_URL_INDEX);
		
		if(subscribe == null)
			return this.redirect(request,response,"未找到订阅信息",ViewConstant.STUDENT_URL_INDEX);
		
		studentService.unsubscribe(subscribe);
		
		return this.redirect(request,response,"订阅已取消",ViewConstant.STUDENT_URL_INDEX);

	}
}