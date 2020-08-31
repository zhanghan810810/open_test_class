package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entry.Course;
import com.example.demo.vo.student.FindCourseVo;

/**
 * @author: zhh
 * @description: 课程dao
 * @data: 2020-08-29
 **/
public interface CourseRepository extends JpaRepository<Course,String>{

	public Course findByCourseNameAndTeacherIdAndCourseStatus(String courseName,String teacherId,Boolean courseStatus);
	
	public List<Course> findByTeacherIdAndCourseStatus(String teacherId,Boolean courseStatus);
	 
	@Query("SELECT NEW com.example.demo.vo.student.FindCourseVo(s.courseId,s.courseName,s.teacherId,l.userName,u.subscribeId) "
			+ "FROM Course s "
			+ "INNER JOIN LoginUser l ON s.teacherId = l.userId "
			+ "LEFT JOIN Subscribe u ON s.courseId = u.course AND u.studentId = ?1 "
			+ "WHERE s.courseStatus = 1")
	List<FindCourseVo> findCoursesAndIsSubscribed(String studentId);
}
