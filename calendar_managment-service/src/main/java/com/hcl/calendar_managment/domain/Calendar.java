package com.hcl.calendar_managment.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="calendars")
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="calendar_id")
	private Long calendarId;
	
	@Column(name = "training_id")
	private Long trainingId;
	
	@Column(name = "training_name")
	private String trainingName;

	@Transient
	private  List<Schedule> schedules =new ArrayList<>();
	
	@Transient
	private  List<User> user =new ArrayList<>();
	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name ="created_at")
	private Date createdAt;
	
	@Column(name ="updated_at")
	private Date updatedAt;

	
	
	public Calendar() {
		super();
	}

	
	
	public Calendar(Long calendarId, Long trainingId, String trainingName, Date startDate, Date endDate, Date createdAt,
			Date updatedAt, List<Schedule> schedules, List<User> user) {
		super();
		this.calendarId = calendarId;
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.schedules = schedules;
		this.user = user;
	}

	public Long getCalendarId() {
		return calendarId;
	}



	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}



	public Long getTrainingId() {
		return trainingId;
	}



	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}



	public String getTrainingName() {
		return trainingName;
	}



	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
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



	public List<Schedule> getSchedules() {
		return schedules;
	}



	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}



	public List<User> getUser() {
		return user;
	}



	public void setUser(List<User> user) {
		this.user = user;
	}



	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}


}
