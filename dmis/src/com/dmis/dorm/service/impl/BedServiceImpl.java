package com.dmis.dorm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.dorm.dao.BedDao;
import com.dmis.dorm.entity.Bed;
import com.dmis.dorm.service.BedService;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

@Service
public class BedServiceImpl implements BedService{

	@Resource
	private BedDao bedDao;
	
	
	public BedDao getBedDao() {
		return bedDao;
	}


	public void setBedDao(BedDao bedDao) {
		this.bedDao = bedDao;
	}


	@Override
	public ResultAndTotal<Bed> searchBedAndTotal(PageUtil pageUtil) {
		ResultAndTotal<Bed> res = new ResultAndTotal<Bed>();
		
		res.setRows(bedDao.getBedListQuery(pageUtil));
		res.setTotal(bedDao.getBedTotalQuery(pageUtil));
		
		return res;
	}

}
