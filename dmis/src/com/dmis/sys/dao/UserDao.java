package com.dmis.sys.dao;

import com.dmis.sys.entity.User;

/**
 * 用户dao
 * @author Administrator
 *
 */
public interface UserDao {

	/*
	 * 登陆
	 * 
	 */
	public User login(String username);
	
	/**
	 * 根据用户名获得用户
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);
}
