package com.dmis.dorm.service;

import java.util.List;
import java.util.Map;

import com.dmis.dorm.entity.Building;
import com.dmis.sys.entity.User;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

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
	public ResultAndTotal<Building> getListQuery(PageUtil pageUtil);
	
	
	/**
	 * 条件查询列表
	 * @return
	 */
	public List<Building> getListAll();
	
	
	public int saveBuild(Building building);
	
	public int delBuilds(String ids);
	
	
	/**
	 * 获得楼宇实体
	 * @param id
	 * @return
	 */
	public Building getBuildEntity(long id);
	
	
	/**
	 * 获得楼管列表
	 * @param buildId
	 * @return
	 */
	public List<User> getBuildPipes(long buildId);
	
	
	/**
	 * 添加楼管
	 * @param map
	 * @return
	 */
	public int addBuildPipe(Map<String, Long> map);
	
	
	/**
	 * 删除楼管
	 * @param id
	 * @return
	 */
	public int delBuildPipe(long id);
}
