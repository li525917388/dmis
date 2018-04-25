package com.dmis.sys.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dmis.sys.dao.UserDao;
import com.dmis.sys.entity.User;
import com.dmis.sys.service.UserService;

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

	
	
	
}
