package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entry.Subscribe;

public interface SubscribeRepository extends JpaRepository<Subscribe,String>{
 
	public Subscribe findByCourseIdAndStudentId(String courseId,String studentId);
}
