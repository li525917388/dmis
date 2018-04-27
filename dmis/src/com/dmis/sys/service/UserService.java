package com.dmis.sys.service;

import com.dmis.sys.entity.User;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

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

	
	
	/**
	 * 搜获得用户列表
	 * @param pageUtil
	 * @return
	 */
	public ResultAndTotal<User> searchUser(PageUtil pageUtil);
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public int saveUser(User user);
	
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delUser(long id);
	
	
	/**
	 * 批量删除用户
	 * @param ids
	 * @return
	 */
	public int delUsers(String ids);
	
	
	
	/**
	 * 获得用户实体
	 * @param id
	 * @return
	 */
	public User getUserEntity(long id);
}
