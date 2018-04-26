package com.dmis.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dmis.sys.dao.RoleDao;
import com.dmis.sys.entity.Menu;
import com.dmis.sys.entity.Role;
import com.dmis.sys.service.RoleService;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

@Transactional(readOnly = false)
@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;
	
	
	public RoleDao getRoleDao() {
		return roleDao;
	}


	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}


	@Override
	public ResultAndTotal<Role> searchRole(PageUtil pageUtil) {
		ResultAndTotal<Role> res = new ResultAndTotal<Role>();
		
		res.setRows(roleDao.getRoles(pageUtil));
		res.setTotal(roleDao.getRoleTotal(pageUtil));
		
		return res;
	}


	@Override
	public List<Menu> getMenuByRole(long rid) {
		// TODO Auto-generated method stub
		return roleDao.getMenuByRole(rid);
	}


	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void newRoleMenu(String mids, long rid) {
		
		String[] midArray = mids.split(",");
		
		roleDao.delRoleMenu(rid);
		
		for(String mid : midArray){
			
			Map<String, Long> map = new HashMap<String, Long>();
			map.put("mid", Long.valueOf(mid));
			map.put("rid", rid);
			
			roleDao.addRoleMenu(map);
		}
	}

}
