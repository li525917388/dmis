package com.dmis.dorm.dao;

import java.util.List;

import com.dmis.dorm.entity.Bed;
import com.dmis.dorm.entity.DormType;
import com.dmis.util.PageUtil;

/**
 * 床位dao
 * @author Administrator
 *
 */
public interface BedDao {

	/**
	 * 获得床位列表
	 * @param pu
	 * @return
	 */
	public List<Bed> getBedListQuery(PageUtil pu);
	
	
	/**
	 * 获得床位列表
	 * @param pu
	 * @return
	 */
	public int getBedTotalQuery(PageUtil pu);
	
	
	/**
	 * 获得宿舍类型列表
	 * @return
	 */
	public List<DormType> getDormTypeList();
}
