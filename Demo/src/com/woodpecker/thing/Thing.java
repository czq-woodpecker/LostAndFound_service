package com.woodpecker.thing;

import com.woodpecker.user.User;

public class Thing {
	
	private Integer tid;
	private Integer ttype;//Àà±ð
	private String tname;
	private String tplace;
	private String tfeature;//ÃèÊö
	private String tphoto;
	private Integer tstate;
	private Integer tbelong;
	private String tphone;
	private User user;
	
	//constructor


	public Thing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Thing(Integer tid, Integer ttype, String tname, String tplace, String tfeature, String tphoto, Integer tstate,
			Integer tbelong, String tphone, User user) {
		super();
		this.tid = tid;
		this.ttype = ttype;
		this.tname = tname;
		this.tplace = tplace;
		this.tfeature = tfeature;
		this.tphoto = tphoto;
		this.tstate = tstate;
		this.tbelong = tbelong;
		this.tphone = tphone;
		this.user = user;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getTtype() {
		return ttype;
	}

	public void setTtype(Integer ttype) {
		this.ttype = ttype;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTplace() {
		return tplace;
	}

	public void setTplace(String tplace) {
		this.tplace = tplace;
	}

	public String getTfeature() {
		return tfeature;
	}

	public void setTfeature(String tfeature) {
		this.tfeature = tfeature;
	}

	public String getTphoto() {
		return tphoto;
	}

	public void setTphoto(String tphoto) {
		this.tphoto = tphoto;
	}

	public Integer getTstate() {
		return tstate;
	}

	public void setTstate(Integer tstate) {
		this.tstate = tstate;
	}

	public Integer getTbelong() {
		return tbelong;
	}

	public void setTbelong(Integer tbelong) {
		this.tbelong = tbelong;
	}

	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	









	
	
	
	
	
	
}
