package com.dmis.dorm.service;

import com.dmis.dorm.entity.Dormitory;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

/**
 * 宿舍service
 * @author Administrator
 *
 */
public interface DormitoryService {

	/**
	 * 获得苏宿舍列表
	 * @return
	 */
	public ResultAndTotal<Dormitory> searchAndTotal(PageUtil pageUtil);
	
	
	/**
	 * 新增
	 * @param dorm
	 * @return
	 */
	public long add(Dormitory dorm);
}
