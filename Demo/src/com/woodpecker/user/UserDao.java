package com.woodpecker.user;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class UserDao extends HibernateDaoSupport{

	public User login(User user) {
		List<User> list = this.getHibernateTemplate().find("from User where username = ? and password = ?",user.getUsername(),user.getPassword());
		if(list.size() != 0){
			return list.get(0);
		}
		else {
			return null;
		}
	}

	public User register(User user) {
		this.getHibernateTemplate().save(user);
		return null;
	}

	public User findByUsername(String username) {
		List<User> list = this.getHibernateTemplate().find("from User where username = ?",username);
		if (list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	public void updateInfo(User existUser) {
		this.getHibernateTemplate().update(existUser);
	}


}
