package com.woodpecker.user;

import org.springframework.transaction.annotation.Transactional;

//开启事务
@Transactional
public class UserService {
	//注入userDao
	private UserDao userDao;
	
	
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}




	public User login(User user) {
		return userDao.login(user);
	}




	public User register(User user) {
		return userDao.register(user);
	}




	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}




	public void updateInfo(User existUser) {
		userDao.updateInfo(existUser);
	}


}
