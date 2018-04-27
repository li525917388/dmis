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
	
	
	public List<Role> getRoleByUser(long uid);
	
	/**
	 * 用户添加角色
	 * @param map
	 * @return
	 */
	public int addUserRole(Map<String, Long> map);
	
	
	/**
	 * 删除用户下角色
	 * @param rid
	 * @return
	 */
	public int delUserRole(long uid);
	
	
	/**
	 * 新增角色
	 * @param role
	 * @return
	 */
	public int addRole(Role role);
	
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public int updateRole(Role role);
	
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	public int delRole(long id);
	
	
	/**
	 * 获得角色实体
	 * @param id
	 * @return
	 */
	public Role getRoleEntity(long id);
}
