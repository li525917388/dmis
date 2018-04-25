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
	
	
	/**
	 * 新增
	 * @param dorm
	 * @return
	 */
	public long add(Dormitory dorm);
	
	
	/**
	 * 修改
	 * @param dorm
	 * @return
	 */
	public long update(Dormitory dorm);
	
	/**
	 * 查看
	 * @param dorm
	 * @return
	 */
	public Dormitory getEntity(long id);
	
	/**
	 * 批量删除
	 * @param dorm
	 * @return
	 */
	public int del(List<Long> list);
	
	/**
	 * 批量删除
	 * @param dorm
	 * @return
	 */
	public int delStr(String ids);
}
