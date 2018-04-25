package com.dmis.dorm.service;

import com.dmis.dorm.entity.Bed;
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
}
