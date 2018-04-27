package com.dmis.dorm.service;

import java.util.List;

import com.dmis.dorm.entity.Building;

/**
 * 楼宇service
 * @author Administrator
 *
 */
public interface BuildingService {

	/**
	 * 条件查询列表
	 * @return
	 */
	public List<Building> getListQuery();
}
