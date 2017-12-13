package com.woodpecker.user;

public class User {
	private  Integer uid;
	private String username;
	private String password;
	private String nickname;
	private String phone;
	private String sex;
	private String usericon;
	private String email;
	private String miaoshu;
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	


	public User(Integer uid, String username, String password, String nickname, String phone, String sex,
			String usericon, String email, String describe) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.phone = phone;
		this.sex = sex;
		this.usericon = usericon;
		this.email = email;
		this.miaoshu = miaoshu;
	}



	public Integer getUid() {
		return uid;
	}



	public void setUid(Integer uid) {
		this.uid = uid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getUsericon() {
		return usericon;
	}



	public void setUsericon(String usericon) {
		this.usericon = usericon;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}







	public String getMiaoshu() {
		return miaoshu;
	}



	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}



	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", phone=" + phone + ", sex=" + sex + ", usericon=" + usericon + ", email=" + email + ", describe="
				+ miaoshu + "]";
	}



	
	
	
}
