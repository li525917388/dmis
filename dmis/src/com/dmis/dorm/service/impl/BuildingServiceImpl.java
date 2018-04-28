package com.dmis.dorm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.dorm.dao.BuildingDao;
import com.dmis.dorm.entity.Building;
import com.dmis.dorm.service.BuildingService;
import com.dmis.sys.entity.User;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

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
	public ResultAndTotal<Building> getListQuery(PageUtil pageUtil) {
		ResultAndTotal<Building> res = new ResultAndTotal<Building>();
		
		res.setRows(buildingDao.getListQuery(pageUtil));
		res.setTotal(buildingDao.getBuildTotal(pageUtil));
		
		return res;
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



	@Override
	public List<Building> getListAll() {
		// TODO Auto-generated method stub
		return buildingDao.getListAll();
	}



	@Override
	public int saveBuild(Building building) {

		if(building.getId() == null ) 
			return buildingDao.addBuild(building);
					
		return buildingDao.updateBuild(building);
	}



	@Override
	public int delBuilds(String ids) {
		int res = 0;
		
		String[] idss = ids.split(",");
		
		for(String id : idss){
			
			res = buildingDao.delBuild(Long.valueOf(id));
		}
		return res;
	}

}
