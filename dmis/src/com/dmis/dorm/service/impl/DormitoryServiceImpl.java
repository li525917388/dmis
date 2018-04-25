package com.dmis.dorm.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.dorm.dao.DormitoryDao;
import com.dmis.dorm.entity.DormPerson;
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



	@Override
	public long save(Dormitory dorm) {
		
		if(dorm.getId() == null){
			
			return dormitoryDao.add(dorm);
		}else{
			
			return dormitoryDao.update(dorm);
		}
		
	}



	@Override
	public Dormitory getEntity(long id) {
		
		return dormitoryDao.getEntity(id);
	}



	@Override
	public int del(long id) {

		return 1;
	}



	@Override
	public int dels(String ids) {
		
		List<Long> list = new ArrayList<Long>();
		
		String[] array = ids.split(",");
		
		for(String s : array){
			
			list.add(Long.valueOf(s));
		}
		
		return dormitoryDao.del(list);
	}



	@Override
	public List<DormPerson> getDormPersons(long dormId) {
		// TODO Auto-generated method stub
		return dormitoryDao.getDormPersons(dormId);
	}



	@Override
	public int dormAddPerson(DormPerson dorm) {
		// TODO Auto-generated method stub
		return dormitoryDao.dormAddPerson(dorm);
	}



	@Override
	public int dormRemovePerson(long stuId) {
		// TODO Auto-generated method stub
		return dormitoryDao.dormRemovePerson(stuId);
	}

}
