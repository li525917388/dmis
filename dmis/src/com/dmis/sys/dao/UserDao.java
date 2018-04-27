package com.dmis.sys.dao;

import java.util.List;

import com.dmis.sys.entity.User;
import com.dmis.util.PageUtil;

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
	
	
	public List<User> getUsers(PageUtil pageUtil);
	
	
	public int getUserTotal(PageUtil pageUtil);
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delUser(long id);
	
	
	/**
	 * 获得用户实体
	 * @param id
	 * @return
	 */
	public User getUserEntity(long id);
}
