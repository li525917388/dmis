package com.dmis.sys.entity;

/**
 * 用户表
 * @author Administrator
 *
 */
public class User {
	
	public static final String SESSION_USER = "my_123_user";

	//id
	private Long id;
	
	//用户名
	private String username;
	
	//密码
	private String pwd;
	
	//姓名
	private String name;
	
	//性别
	private int sex;
	
	//班级
	private Long classId;
	
	//头像
	private String headIcon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getHeadIcon() {
		return headIcon;
	}

	public void setHeadIcon(String headIcon) {
		this.headIcon = headIcon;
	}

	public static String getSessionUser() {
		return SESSION_USER;
	}

	
}
