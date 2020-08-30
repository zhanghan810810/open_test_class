package com.example.demo.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author: zhh
 * @description: 订阅实体
 * @data: 2020-08-29
 **/
@Data
@Entity
@Table(name="subscribe")
public class Subscribe {

	/*
	 * 主键
	 */
	@Id
	@Column(name="subscribe_id")
	@GeneratedValue(generator = "idGenerator") 
	@GenericGenerator(name="idGenerator", strategy="uuid")
	private String subscribeId;
	
	/*
	 * 学生id
	 */
	@Column(name="studentId")
	private String studentId;
	
	/*
	 * 课程id
	 */
//	@Column(name="course_id")
//	private String courseId;
	
	@ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Subscribe{");
		sb.append("subscribeId=").append(subscribeId);
//		sb.append(", courseId='").append(courseId).append('\'');
		sb.append(", studentId=").append(studentId);
		sb.append(", course=").append(course);
		sb.append('}');
		return sb.toString();
	}
}
