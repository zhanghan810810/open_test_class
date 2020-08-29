package com.example.demo.entry;

/**
 * @author: zhh
 * @description: 用户类型枚举
 * @data: 2020-08-29
 **/
public enum UserRole {

	ADMIN("管理员"),TEACHER("教师"),STUDENT("学生");
	
	private String desc;
	private UserRole(String desc){
        this.desc = desc;
    }
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
