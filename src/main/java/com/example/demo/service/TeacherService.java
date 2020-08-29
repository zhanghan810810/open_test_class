package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entry.Course;
import com.example.demo.vo.student.FindCourseVo;

public interface TeacherService {

	public Course findByCourseNameAndTeacherIdAndCourseStatus(String courseName,String teacherId,Boolean courseStatus);
	
	public List<Course> findByTeacherIdAndCourseStatus(String teacherId,Boolean courseStatus);
	 
	public List<FindCourseVo> findCoursesAndIsSubscribed(String studentId);
	
	public Course findById(String id);
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void save(Course course);
}
