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
}
