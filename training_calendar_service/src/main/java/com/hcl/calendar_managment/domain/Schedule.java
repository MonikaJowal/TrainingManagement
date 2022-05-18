package com.hcl.calendar_managment.domain;

import java.util.Date;

public class Schedule {

	private String name;
	private Long employeeId;
	private String programeName;
	private Date startDate;
	private Date endDate;
	private Date createdAt;
	private Date updatedAt;
	
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Schedule(String name, Long employeeId, String programeName, Date startDate, Date endDate, Date createdAt,
			Date updatedAt) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.programeName = programeName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getProgrameName() {
		return programeName;
	}

	public void setProgrameName(String programeName) {
		this.programeName = programeName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
