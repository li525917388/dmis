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
}
