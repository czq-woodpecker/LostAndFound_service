package com.woodpecker.thing;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

//��������
@Transactional
public class ThingService {
	//ע��thingDao
	private ThingDao thingDao;

	public void setThingDao(ThingDao thingDao) {
		this.thingDao = thingDao;
	}

	public void add(Thing thing) {
		thingDao.add(thing);
	}

	public List<Thing> findAllLost() {
		return thingDao.findAllLost();
	}

	public List<Thing> findByType(Integer belong, Integer type) {
		return thingDao.findByType(belong,type);
	}

	public List<Thing> findAllThingByBelong(Integer tbelong) {
		return thingDao.findAllThingByBelong(tbelong);
	}
	
	

}
