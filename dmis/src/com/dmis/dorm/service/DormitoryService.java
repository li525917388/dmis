package com.dmis.dorm.service;

import java.util.List;

import com.dmis.dorm.entity.DormPerson;
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
	 * 保存
	 * @param dorm
	 * @return
	 */
	public long save(Dormitory dorm);
	
	
	/**
	 * 获得实体
	 * @param dorm
	 * @return
	 */
	public Dormitory getEntity(long id);
	
	
	/**
	 * 获得实体
	 * @param dorm
	 * @return
	 */
	public int del(long id);
	
	
	/**
	 * 获得实体
	 * @param dorm
	 * @return
	 */
	public int dels(String ids);
	
	
	/**
	 * 获得宿舍人员
	 * @return
	 */
	public List<DormPerson> getDormPersons(long dormId);
	
	
	/**
	 * 宿舍添加人员
	 * @return
	 */
	public int dormAddPerson(DormPerson dorm);
	
	
	/**
	 * 宿舍删除人员
	 * @param stuId
	 * @return
	 */
	public int dormRemovePerson(long id);
}
