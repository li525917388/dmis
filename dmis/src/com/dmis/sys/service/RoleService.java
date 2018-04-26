package com.dmis.sys.service;

import java.util.List;

import com.dmis.sys.entity.Menu;
import com.dmis.sys.entity.Role;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

/**
 * 角色service
 * @author Administrator
 *
 */
public interface RoleService {

	/**
	 * 搜获得角色列表
	 * @param pageUtil
	 * @return
	 */
	public ResultAndTotal<Role> searchRole(PageUtil pageUtil);
	
	
	/**
	 * 根据角色id获得所有菜单
	 * @param rid
	 * @return
	 */
	public List<Menu> getMenuByRole(long rid);
	
	
	/**
	 * 重新授权菜单
	 * @param mids
	 * @param rid
	 */
	public void newRoleMenu(String mids,long rid);
}
