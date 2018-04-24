package com.dmis.dorm.dao;

import java.util.List;

import com.dmis.dorm.entity.Dormitory;
import com.dmis.util.PageUtil;

/**
 * 宿舍dao
 * @author Administrator
 *
 */
public interface DormitoryDao {

	/**
	 * 获得苏宿舍列表
	 * @return
	 */
	public List<Dormitory> getListQuery(PageUtil pageUtil);
	
	/**
	 * 获得苏宿舍列表总数
	 * @return
	 */
	public int getTotalQuery(PageUtil pageUtil);
}
