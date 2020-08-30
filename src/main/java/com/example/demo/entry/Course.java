package com.example.demo.entry;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: zhh
 * @description: 课程实体
 * @data: 2020-08-29
 **/
@NoArgsConstructor 
@AllArgsConstructor
@Data
@Entity
@Table(name="course")
public class Course {

	/*
	 * 主键
	 */
	@Id
	@Column(name="course_id")
	@GeneratedValue(generator = "idGenerator") 
	@GenericGenerator(name="idGenerator", strategy="uuid")
	private String courseId;
	
	/*
	 * 课程名称
	 */
	@Column(name="course_name")
	private String courseName;
	
	/*
	 * 教师id
	 */
	@Column(name="teacher_id")
	private String teacherId;
	
	/*
	 * 订阅数量
	 */
	@Column(name="sub_cnt")
	private Integer subCnt = 0;
	
	/*
	 * 是否删除标记
	 */
	@Column(name="course_status")
	private Boolean courseStatus = true;
	
	@OneToMany()
	@JoinColumn(name="course_id")
    private List<Subscribe> subscribes = new ArrayList<Subscribe>();

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Course{");
		sb.append("courseId=").append(courseId);
		sb.append(", courseName='").append(courseName).append('\'');
		sb.append(", teacherId=").append(teacherId);
		sb.append(", courseStatus=").append(courseStatus);
		sb.append(", subCnt=").append(subCnt);
		sb.append('}');
		return sb.toString();
	}
}
