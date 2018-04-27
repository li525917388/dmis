package com.dmis.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dmis.sys.dao.UserDao;
import com.dmis.sys.entity.User;
import com.dmis.sys.service.UserService;
import com.dmis.util.PageUtil;
import com.dmis.util.ResultAndTotal;

@Transactional(readOnly = false)
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(String username) {
		// TODO Auto-generated method stub
		return userDao.login(username);
	}

	@Override
	public ResultAndTotal<User> searchUser(PageUtil pageUtil) {
		ResultAndTotal<User> res = new ResultAndTotal<User>();
		
		res.setRows(userDao.getUsers(pageUtil));
		res.setTotal(userDao.getUserTotal(pageUtil));
		
		return res;
	}

	@Override
	public int saveUser(User user) {
		if(user.getId() == null) return userDao.addUser(user);
		
		return userDao.updateUser(user);
	}

	@Override
	public int delUser(long id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public int delUsers(String ids) {
		
		int res = 0;
		
		String[] idArray = ids.split(",");
		
		for(String id : idArray){
			
			res = userDao.delUser(Long.valueOf(id));
		}
		return res;
	}

	@Override
	public User getUserEntity(long id) {
		// TODO Auto-generated method stub
		return userDao.getUserEntity(id);
	}

	
	
	
}
