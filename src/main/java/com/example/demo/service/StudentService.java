package com.example.demo.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entry.Subscribe;

/**
 * @author: zhh
 * @description: 学生service
 * @data: 2020-08-29
 **/
public interface StudentService {

	/**
	 * @description 通过订阅id查找订阅信息
	 * @param id 订阅id
	 * @return
	 */
	public Subscribe findById(String id);
	
	/**
	 * @description 保存订阅信息
	 * @param subscribe 订阅信息
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED) 
	public void save(Subscribe subscribe);
	
	/**
	 * @description 通过课程id和学生id查找订阅信息
	 * @param courseId 课程id
	 * @param studentId 学生id
	 * @return
	 */
	public Subscribe findByCourseIdAndStudentId(String courseId,String studentId);
	
	/**
	 * @description 订阅课程
	 * @param subscribe 订阅信息
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED) 
	public void subscribe(Subscribe subscribe);
	
	/**
	 * @description 取消订阅课程
	 * @param subscribe 订阅信息
	 * @return
	 */
	@Transactional(propagation=Propagation.REQUIRED) 
	public void unsubscribe(Subscribe subscribe);
}
