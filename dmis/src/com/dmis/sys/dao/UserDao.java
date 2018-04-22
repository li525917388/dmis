package com.dmis.sys.dao;

import com.dmis.sys.entity.User;

/**
 * 用户dao
 * @author Administrator
 *
 */
public interface UserDao {

	
	public User login(User user);
	
	/**
	 * 根据用户名获得用户
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username);
}
