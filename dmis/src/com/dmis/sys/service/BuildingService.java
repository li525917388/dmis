package com.dmis.sys.service;

import java.util.List;

import com.dmis.sys.entity.Building;

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