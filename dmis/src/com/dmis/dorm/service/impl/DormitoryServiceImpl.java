package com.dmis.dorm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.dorm.dao.DormitoryDao;
import com.dmis.dorm.entity.Dormitory;
import com.dmis.dorm.service.DormitoryService;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

@Service
public class DormitoryServiceImpl implements DormitoryService {

	@Resource
	private DormitoryDao dormitoryDao;
	
	
	
	public DormitoryDao getDormitoryDao() {
		return dormitoryDao;
	}



	public void setDormitoryDao(DormitoryDao dormitoryDao) {
		this.dormitoryDao = dormitoryDao;
	}



	@Override
	public ResultAndTotal<Dormitory> searchAndTotal(PageUtil pageUtil) {
		
		ResultAndTotal<Dormitory> res = new ResultAndTotal<Dormitory>();
		
		res.setRows(dormitoryDao.getListQuery(pageUtil));
		res.setTotal(dormitoryDao.getTotalQuery(pageUtil));
		
		return res;
	}

}
