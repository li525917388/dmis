package com.dmis.other.service;

import com.dmis.other.entity.AccessPerson;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

/**
 * 出入service
 * @author Administrator
 *
 */
public interface AccessService {

	/**
	 * 搜索访问人员
	 * @param pageUtil
	 * @return
	 */
	public ResultAndTotal<AccessPerson> searchAccessPerson(PageUtil pageUtil);
	
	
	/**
	 * 保存访问人员信息
	 * @param accessPerson
	 * @return
	 */
	public int saveAccessPerson(AccessPerson accessPerson);
	
	
	/**
	 * 获得来访人员信息
	 * @param id
	 * @return
	 */
	public AccessPerson getAccessPersonEntity(long id);
}
