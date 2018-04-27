package com.dmis.sys.dao;

import java.util.List;

import com.dmis.sys.entity.Menu;

/**
 * 菜单dao
 * @author Administrator
 *
 */
public interface MenuDao {

	/**
	 * 获得用户左侧菜单
	 * @param uid
	 * @return
	 */
	public List<Menu> getMenuByUid(long uid);
	
	
	/**
	 * 获得菜单列表
	 * @return
	 */
	public List<Menu> getMenusQuery();
	
	
	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	public int addMenu(Menu menu);
	
	
	/**
	 * 更新菜单
	 * @param menu
	 * @return
	 */
	public int updateMenu(Menu menu);
	
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	public int delMenu(long id);
	
	
	/**
	 * 获得菜单实体
	 * @param id
	 * @return
	 */
	public Menu getMenuEntity(long id);
}
