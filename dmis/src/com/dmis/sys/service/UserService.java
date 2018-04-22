package com.dmis.sys.service;

import com.dmis.sys.entity.User;

/**
 * 用户service
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 登录
	 * @param username
	 * @param pwd
	 */
	public User login(String username, String pwd);
}
