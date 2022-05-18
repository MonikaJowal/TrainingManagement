package com.hcl.dashboardcreation.service;

import org.springframework.stereotype.Service;

public interface DashboardService {
	public int totalTrainings();
	public double averageRating();
	public double totalTrainingHrs();
	public double budget();
	public String trainingType();
	public String trainingStatus();
	public String monthlyTrainingView();
	
	
	
	
	

}
