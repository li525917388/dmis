package com.dmis.sys.service;

import com.dmis.sys.entity.User;

/**
 * 用户service
 * @author Administrator
 *
 */
public interface UserService {
	

	/**
	 * 登陆
	 * @param username
	 * 
	 */
	public User login(String username);

	
}
