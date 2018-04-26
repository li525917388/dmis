package com.dmis.other.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.other.dao.AccessDao;
import com.dmis.other.entity.AccessMaterial;
import com.dmis.other.entity.AccessPerson;
import com.dmis.other.service.AccessService;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

@Service
public class AccessServiceImpl implements AccessService {

	@Resource
	private AccessDao accessDao;
	
	
	public AccessDao getAccessDao() {
		return accessDao;
	}

	public void setAccessDao(AccessDao accessDao) {
		this.accessDao = accessDao;
	}

	@Override
	public ResultAndTotal<AccessPerson> searchAccessPerson(PageUtil pageUtil) {
		
		ResultAndTotal<AccessPerson> res = new ResultAndTotal<AccessPerson>();
		
		res.setRows(accessDao.getAccessPersons(pageUtil));
		res.setTotal(accessDao.getAccessPersonTotal(pageUtil));
		
		return res;
	}

	@Override
	public int saveAccessPerson(AccessPerson accessPerson) {
		
		if(accessPerson.getId() == null) return accessDao.addAccessPerson(accessPerson);
		
		else return accessDao.updateAccessPerson(accessPerson);
	}

	@Override
	public AccessPerson getAccessPersonEntity(long id) {
		
		return accessDao.getAccessPersonEntity(id);
	}

	@Override
	public ResultAndTotal<AccessMaterial> searchAccessMaterial(PageUtil pageUtil) {
		ResultAndTotal<AccessMaterial> res = new ResultAndTotal<AccessMaterial>();
		
		res.setRows(accessDao.getAccessMaterials(pageUtil));
		res.setTotal(accessDao.getAccessMaterialTotal(pageUtil));
		
		return res;
	}

	@Override
	public int saveAccessMaterial(AccessMaterial accessMaterial) {
		if(accessMaterial.getId() == null) return accessDao.addAccessMaterial(accessMaterial);
		
		else return accessDao.updateAccessMaterial(accessMaterial);
	}

	@Override
	public AccessMaterial getAccessMaterialEntity(long id) {
		// TODO Auto-generated method stub
		return accessDao.getAccessMaterialEntity(id);
	}

}
