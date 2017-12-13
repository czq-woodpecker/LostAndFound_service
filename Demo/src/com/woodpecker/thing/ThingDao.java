package com.woodpecker.thing;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class ThingDao extends HibernateDaoSupport{


	public void add(Thing thing) {
		this.getHibernateTemplate().save(thing);
	}
	
	public List<Thing> findAllLost(){
		List<Thing> list =  this.getHibernateTemplate().find("from Thing where tbelong = ?",0);
		return list;
	}

	public List<Thing> findByType(Integer belong, Integer type) {
		List<Thing> list =  this.getHibernateTemplate().find("from Thing where tbelong = ? and ttype = ?",belong,type);
		return list;
	}

	public List<Thing> findAllThingByBelong(Integer tbelong) {
		List<Thing> list =  this.getHibernateTemplate().find("from Thing where tbelong = ?",tbelong);
		return list;
	}

}
