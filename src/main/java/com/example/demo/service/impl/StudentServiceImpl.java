package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseRepository;
import com.example.demo.dao.SubscribeRepository;
import com.example.demo.entry.Course;
import com.example.demo.entry.Subscribe;
import com.example.demo.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubscribeRepository subscribeRepository;
	
	
	public Subscribe findById(String id) {
	
		return subscribeRepository.findById(id).orElse(null);
	}
	

	public void save(Subscribe subscribe) {
		subscribeRepository.save(subscribe);
	}
	
	public Subscribe findByCourseIdAndStudentId(String courseId,String studentId) {
		
		return subscribeRepository.findByCourseIdAndStudentId(courseId,studentId);
	}
	

	public void subscribe(Subscribe subscribe) {
		
		Course course = courseRepository.findById(subscribe.getCourseId()).orElse(null);
		course.setSubCnt(course.getSubCnt() + 1);
		
		subscribeRepository.save(subscribe);
		courseRepository.save(course);
		
	}
	

	public void unsubscribe(Subscribe subscribe) {
		Course course = courseRepository.findById(subscribe.getCourseId()).orElse(null);
		course.setSubCnt(course.getSubCnt() - 1);
		
		subscribeRepository.delete(subscribe);
		courseRepository.save(course);
	}
}
