package com.dmis.sys.dao;

import java.util.List;
import java.util.Map;

import com.dmis.sys.entity.Menu;
import com.dmis.sys.entity.Role;
import com.dmis.util.PageUtil;

public interface RoleDao {

	public List<Role> getRoles(PageUtil pageUtil);
	
	
	public int getRoleTotal(PageUtil pageUtil);
	
	
	public List<Menu> getMenuByRole(long rid);
	
	/**
	 * 权限添加菜单
	 * @param map
	 * @return
	 */
	public int addRoleMenu(Map<String, Long> map);
	
	
	/**
	 * 删除角色下所有菜单
	 * @param rid
	 * @return
	 */
	public int delRoleMenu(long rid);
}
