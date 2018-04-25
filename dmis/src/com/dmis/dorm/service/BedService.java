package com.dmis.dorm.service;

import java.util.List;

import com.dmis.dorm.entity.Bed;
import com.dmis.dorm.entity.DormType;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

/**
 * 床位和宿舍类型service
 * @author Administrator
 *
 */
public interface BedService {

	/**
	 * 查询
	 * @param pageUtil
	 * @return
	 */
	public ResultAndTotal<Bed> searchBedAndTotal(PageUtil pageUtil);
	
	
	/**
	 * 获得宿舍类型列表
	 * @return
	 */
	public List<DormType> getDormTypeList();
}
