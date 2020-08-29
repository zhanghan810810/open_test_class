package com.example.demo.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entry.Subscribe;

public interface StudentService {

	public Subscribe findById(String id);
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void save(Subscribe loginUser);
	
	public Subscribe findByCourseIdAndStudentId(String courseId,String studentId);
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void subscribe(Subscribe subscribe);
	
	@Transactional(propagation=Propagation.REQUIRED) 
	public void unsubscribe(Subscribe subscribe);
}
