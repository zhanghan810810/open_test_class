package com.example.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entry.Course;
import com.example.demo.vo.student.FindCourseVo;

/**
 * @author: zhh
 * @description: 教师service
 * @data: 2020-08-29
 **/
public interface TeacherService {

	/**
	 * @description 通过课程名称&教师id&课程状态查找课程信息
	 * @param courseName 课程名称
	 * @param teacherId 教师id
	 * @param courseStatus 课程状态
	 * @return
	 */
	public Course findByCourseNameAndTeacherIdAndCourseStatus(String courseName,String teacherId,Boolean courseStatus);
	
	
	/**
	 * @description 通过教师id&课程状态查找课程
	 * @param teacherId 教师id
	 * @param courseStatus 课程状态
	 * @return
	 */
	public List<Course> findByTeacherIdAndCourseStatus(String teacherId,Boolean courseStatus);
	 
	/**
	 * @description 通过学生id查找订阅课程信息
	 * @param studentId 学生id
	 * @return
	 */
	public List<FindCourseVo> findCoursesAndIsSubscribed(String studentId);
	
	/**
	 * @description 通过课程id查找课程信息
	 * @param id 课程id
	 * @return
	 */
	public Course findById(String id);
	
	/**
	 * @description 保存课程信息
	 * @param course 课程信息
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED) 
	public void save(Course course);
}
