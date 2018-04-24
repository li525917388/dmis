package com.dmis.sys.dao;

import java.util.List;

import com.dmis.sys.entity.Building;

/**
 * 楼宇dao
 * @author Administrator
 *
 */
public interface BuildingDao {

	/**
	 * 条件查询列表
	 * @return
	 */
	public List<Building> getListQuery();
}
