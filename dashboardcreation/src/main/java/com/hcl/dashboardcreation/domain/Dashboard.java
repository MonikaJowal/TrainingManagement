package com.hcl.dashboardcreation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dashboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int totalTranining_no;
	private double average_rating;
	private double totalTraining_hr;
	private double budget;
	private String training_status;
	private String training_type;
	
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dashboard(int totalTranining_no, double average_rating, double totalTraining_hr, double budget,
			String training_status, String training_type) {
		super();
		this.totalTranining_no = totalTranining_no;
		this.average_rating = average_rating;
		this.totalTraining_hr = totalTraining_hr;
		this.budget = budget;
		this.training_status = training_status;
		this.training_type = training_type;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTotalTranining_no() {
		return totalTranining_no;
	}
	public void setTotalTranining_no(int totalTranining_no) {
		this.totalTranining_no = totalTranining_no;
	}
	public double getAverage_rating() {
		return average_rating;
	}
	public void setAverage_rating(double average_rating) {
		this.average_rating = average_rating;
	}
	public double getTotalTraining_hr() {
		return totalTraining_hr;
	}
	public void setTotalTraining_hr(double totalTraining_hr) {
		this.totalTraining_hr = totalTraining_hr;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getTraining_status() {
		return training_status;
	}
	public void setTraining_status(String training_status) {
		this.training_status = training_status;
	}
	public String getTraining_type() {
		return training_type;
	}
	public void setTraining_type(String training_type) {
		this.training_type = training_type;
	}
}
