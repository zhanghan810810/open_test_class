package com.example.demo.entry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author: zhh
 * @description: 用户实体
 * @data: 2020-08-29
 **/
@Data
@Entity
@Table(name="login_users")
public class LoginUser {

	/*
	 * 主键，用户名
	 */
	@Id
	@Column(name="user_id")
	private String userId;
	
	/*
	 * 用户姓名
	 */
	@Column(name="user_name")
	private String userName;
	
	/*
	 * 用户密码
	 */
	@Column(name="user_passwd")
	private String userPasswd;
	
	/*
	 * 用户角色
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="user_role")
	private UserRole userRole;
	
	/*
	 * 是否删除标记
	 */
	@Column(name="user_status")
	private Boolean userStatus = true;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("LoginUser{");
		sb.append("userId=").append(userId);
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", userPasswd=").append(userPasswd);
		sb.append(", userRole='").append(userRole).append('\'');
		sb.append(", userStatus='").append(userStatus).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
