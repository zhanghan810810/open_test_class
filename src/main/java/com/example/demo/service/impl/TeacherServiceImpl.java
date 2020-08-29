package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.entry.Course;
import com.example.demo.service.TeacherService;
import com.example.demo.vo.student.FindCourseVo;


@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private CourseRepository courseRepository;
	
	
	public Course findByCourseNameAndTeacherIdAndCourseStatus(String courseName,String teacherId,Boolean courseStatus) {
		
		return courseRepository.findByCourseNameAndTeacherIdAndCourseStatus(courseName,teacherId,courseStatus);
	}
	
	public List<Course> findByTeacherIdAndCourseStatus(String teacherId,Boolean courseStatus){
		return courseRepository.findByTeacherIdAndCourseStatus(teacherId,courseStatus);
	}
	 
	public List<FindCourseVo> findCoursesAndIsSubscribed(String studentId){
		return courseRepository.findCoursesAndIsSubscribed(studentId);
	}
	
	public Course findById(String id) {
		
		return courseRepository.findById(id).orElse(null);
		
	}
	
	public void save(Course course) {
		
		courseRepository.save(course);
	}
}
