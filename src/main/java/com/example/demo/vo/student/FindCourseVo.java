package com.example.demo.vo.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhh
 * @description: 学生列表VO
 * @data: 2020-08-29
 **/
@NoArgsConstructor 
@AllArgsConstructor
@Data
public class FindCourseVo {

	/*
	 * 课程id
	 */
	private String courseId;
	
	/*
	 * 课程名称
	 */
	private String courseName;
	
	/*
	 * 教师id
	 */
	private String teacherId;
	
	/*
	 * 教师名称
	 */
	private String teacherName;
	
	/*
	 * 订阅id
	 */
	private String subscribeId;
}
