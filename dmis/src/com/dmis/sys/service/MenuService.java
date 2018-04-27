package com.dmis.sys.service;

import java.util.List;

import com.dmis.sys.entity.Menu;

/**
 * 菜单service
 * @author Administrator
 *
 */
public interface MenuService {

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
	 * 保存菜单
	 * @param menu
	 * @return
	 */
	public int saveMenu(Menu menu);
	
	
	/**
	 * 获得菜单实体
	 * @param id
	 * @return
	 */
	public Menu getMenuEntity(long id);
	
	
	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	public int delMenu(long id);
	
	
	/**
	 * 批量删除菜单
	 * @param id
	 * @return
	 */
	public int delMenus(String ids);
}
