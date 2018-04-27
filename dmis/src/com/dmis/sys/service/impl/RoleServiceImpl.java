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
	
	
	@Override
	public List<Role> getRoleByUser(long uid) {
		// TODO Auto-generated method stub
		return roleDao.getRoleByUser(uid);
	}


	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void newUserRole(String rids, long uid) {
		
		String[] ridArray = rids.split(",");
		
		roleDao.delUserRole(uid);
		
		for(String rid : ridArray){
			
			Map<String, Long> map = new HashMap<String, Long>();
			map.put("rid", Long.valueOf(rid));
			map.put("uid", uid);
			
			roleDao.addUserRole(map);
		}
	}


	@Override
	public int saveRole(Role role) {
		
		if(role.getId() == null) return roleDao.addRole(role);
		
		return roleDao.updateRole(role);
	}


	@Override
	public int delRole(long id) {

		return roleDao.delRole(id);
	}


	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public int delRoles(String ids) {
		int res = 0;
		
		String[] idArray = ids.split(",");
		
		for(String id : idArray){
			
			res = roleDao.delRole(Long.valueOf(id));
		}
		return res;
	}


	@Override
	public Role getRoleEntity(long id) {
		
		return roleDao.getRoleEntity(id);
	}

}
