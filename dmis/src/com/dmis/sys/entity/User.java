package com.dmis.sys.entity;

/**
 * 用户表
 * @author Administrator
 *
 */
public class User {

	//id
	private Long id;
	
	//用户名
	private String username;
	
	//密码
	private String pwd;
	
	//姓名
	private String name;

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

	
}
