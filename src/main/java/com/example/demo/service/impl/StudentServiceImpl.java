package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SubscribeRepository;
import com.example.demo.entry.Subscribe;
import com.example.demo.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService{


	@Autowired
	private SubscribeRepository subscribeRepository;
	
	
	public Subscribe findById(String id) {
	
		return subscribeRepository.findById(id).orElse(null);
	}
	

	public void save(Subscribe subscribe) {
		subscribeRepository.save(subscribe);
	}
	
	public Subscribe findByCourseIdAndStudentId(String courseId,String studentId) {
		
		return subscribeRepository.findByCourseCourseIdAndStudentId(courseId,studentId);
	}
	

	public void subscribe(Subscribe subscribe) {
		
		subscribeRepository.addSubCntByCoursedId(subscribe.getCourse().getCourseId());
		subscribeRepository.save(subscribe);
		
	}
	

	public void unsubscribe(Subscribe subscribe) {

		subscribeRepository.subSubCntByCoursedId(subscribe.getCourse().getCourseId());
		subscribeRepository.delete(subscribe);
	}
}
