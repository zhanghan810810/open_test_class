package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entry.Subscribe;

/**
 * @author: zhh
 * @description: 订阅dao
 * @data: 2020-08-29
 **/
public interface SubscribeRepository extends JpaRepository<Subscribe,String>{
 
	public Subscribe findByCourseCourseIdAndStudentId(String courseId,String studentId);
	
	@Modifying
	@Query("UPDATE Course c SET c.subCnt = c.subCnt + 1 WHERE courseId = ?1")
	void addSubCntByCoursedId(String coursedId);
	
	@Modifying
	@Query("UPDATE Course c SET c.subCnt = c.subCnt - 1 WHERE courseId = ?1")
	void subSubCntByCoursedId(String coursedId);
	
}
