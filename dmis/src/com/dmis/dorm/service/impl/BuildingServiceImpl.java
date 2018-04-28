package com.dmis.dorm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.dorm.dao.BuildingDao;
import com.dmis.dorm.entity.Building;
import com.dmis.dorm.service.BuildingService;
import com.dmis.sys.entity.User;

@Service
public class BuildingServiceImpl implements BuildingService{

	@Resource
	private BuildingDao  buildingDao;
	
	
	
	public BuildingDao getBuildingDao() {
		return buildingDao;
	}



	public void setBuildingDao(BuildingDao buildingDao) {
		this.buildingDao = buildingDao;
	}



	@Override
	public List<Building> getListQuery() {
		// TODO Auto-generated method stub
		return buildingDao.getListQuery();
	}



	@Override
	public Building getBuildEntity(long id) {
		// TODO Auto-generated method stub
		return buildingDao.getBuildEntity(id);
	}



	@Override
	public List<User> getBuildPipes(long buildId) {
		// TODO Auto-generated method stub
		return buildingDao.getBuildPipes(buildId);
	}



	@Override
	public int addBuildPipe(Map<String, Long> map) {
		// TODO Auto-generated method stub
		return buildingDao.addBuildPipe(map);
	}



	@Override
	public int delBuildPipe(long id) {
		// TODO Auto-generated method stub
		return buildingDao.delBuildPipe(id);
	}

}
