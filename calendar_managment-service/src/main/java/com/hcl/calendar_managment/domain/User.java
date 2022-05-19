package com.hcl.calendar_managment.domain;

import java.util.Date;

public class User {

	private Long id;
	private String username;
	private Long calendarId;
	private String address;
	private String mobileNo; 
	private String password;
	private Date createdAt;
	private Date updateAt;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Long id, String username, Long calendarId, String address, String mobileNo, String password,
			Date createdAt, Date updateAt) {
		super();
		this.id = id;
		this.username = username;
		this.calendarId = calendarId;
		this.address = address;
		this.mobileNo = mobileNo;
		this.password = password;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Long getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}
	
	
}
