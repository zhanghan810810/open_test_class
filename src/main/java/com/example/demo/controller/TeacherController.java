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
import com.example.demo.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: zhh
 * @description: 教师控制器
 * @data: 2020-08-29
 **/
@Slf4j
@Controller
public class TeacherController extends BaseController{

	
	@Autowired
	private TeacherService teacherService;
	

	/*
	 * 首页
	 */
	@RequestMapping(value = "/teacher/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		request.setAttribute("user", user);
		
		List<Course> courses = teacherService.findByTeacherIdAndCourseStatus(user.getUsername(),true);
		
		request.setAttribute("courses", courses);
		
		return ViewConstant.TEACHER_VIEW_INDEX;

	}
	
	/*
	 * 编辑课程
	 */
	@RequestMapping(value = "/teacher/editCourse", method = RequestMethod.GET)
	public String editCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String courseId = request.getParameter("courseId");
		
		Course course = teacherService.findById(courseId);
		
		if(course != null)
			request.setAttribute("course", course);
		
		return ViewConstant.TEACHER_VIEW_EDITCOURSE;

	}
	
	/*
	 * 更新课程
	 */
	@RequestMapping(value = "/teacher/updateCourse", method = RequestMethod.POST)
	public String updateCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		
		Course course = teacherService.findById(courseId);
		
		if(course == null)
			return this.redirect(request,response,"课程不存在",ViewConstant.TEACHER_URL_EDITCOURSE + "?courseId="+courseId);
		
		if(course != null)
			request.setAttribute("course", course);
		
		
		course.setCourseName(courseName);
		
		
		teacherService.save(course);
		
		return this.redirect(request,response,"修改成功",ViewConstant.TEACHER_URL_INDEX);


	}
	
	/*
	 * 添加课程
	 */
	@RequestMapping(value = "/teacher/addCourse", method = RequestMethod.GET)
	public String addCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return ViewConstant.TEACHER_VIEW_ADDCOURSE;

	}
	
	/*
	 * 添加保存课程
	 */
	@RequestMapping(value = "/teacher/saveCourse", method = RequestMethod.POST)
	public String saveCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {

		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String courseName = request.getParameter("courseName");
		
		Course course = teacherService.findByCourseNameAndTeacherIdAndCourseStatus(courseName,user.getUsername(),true);
		
		if(course != null) {
			return this.redirect(request,response,"课程已存在",ViewConstant.TEACHER_URL_ADDCOURSE);
		}

		course = new Course();
		course.setCourseName(courseName);
		course.setTeacherId(user.getUsername());
		
		
		
		teacherService.save(course);
		
		return this.redirect(request,response,"添加成功",ViewConstant.TEACHER_URL_INDEX);


	}
	
	/*
	 * 删除课程
	 */
	@RequestMapping(value = "/teacher/delCourse", method = RequestMethod.POST)
	public String delCourse(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String courseId = request.getParameter("courseId");
		
		Course course = teacherService.findById(courseId);
		
		if(course == null) {
			return this.redirect(request,response,"课程不存在",ViewConstant.TEACHER_URL_INDEX);
		}
		
		course.setCourseStatus(false);
		
		teacherService.save(course);
		
		return this.redirect(request,response,"删除成功",ViewConstant.TEACHER_URL_INDEX);


	}
}