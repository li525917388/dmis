package com.dmis.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.sys.dao.BuildingDao;
import com.dmis.sys.entity.Building;
import com.dmis.sys.service.BuildingService;

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

}
