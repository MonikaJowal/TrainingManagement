package com.hcl.dashboardcreation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.dashboardcreation.domain.Dashboard;
import com.hcl.dashboardcreation.serviceimpl.DashboardServiceImpl;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	public DashboardServiceImpl dashboardServiceimpl;
	
	@GetMapping("/totalNoOfTrainings")
	public Map<String, Integer> totalNoOfTrainings(){
		Map<String, Integer> map=new HashMap<String, Integer>();
		int totalNoTraining=dashboardServiceimpl.totalTrainings();
		map.put("totalNoOfTrainings", totalNoTraining);
		return map;
	}
	
	@GetMapping("/averageRating")
	public Map<String, Double> averageRating(){
		Map<String, Double> map=new HashMap<String, Double>();
		Double averageRatingValue=dashboardServiceimpl.averageRating();
		map.put("averageRating", averageRatingValue);
		return map;
	}
	
	@GetMapping("/totalTrainigHours")
	public Map<String, Double> totalTrainigHours(){
		Map<String, Double> map=new HashMap<String, Double>();
		Double trainingHours=dashboardServiceimpl.totalTrainingHrs();
		map.put("totalTrainigHours", trainingHours);
		return map;
	}
	
	@GetMapping("/budget")
	public Map<String, Double> budget(){
		Map<String, Double> map=new HashMap<String, Double>();
		Double budgets=dashboardServiceimpl.budget();
		map.put("totalTrainigHours", budgets);
		return map;
	}
	
	@GetMapping("/trainingStatus")
	public Map<String, String> trainingStatus(){
		Map<String, String> map=new HashMap<String, String>();
		String trainingstatus=dashboardServiceimpl.trainingStatus();
		map.put("TrainingStatus", trainingstatus);
		return map;
	}
	
	@GetMapping("/trainingType")
	public Map<String, String> trainingType(){
		Map<String, String> map=new HashMap<String, String>();
		String trainingtype=dashboardServiceimpl.trainingType();
		map.put("TrainingType", trainingtype);
		return map;
	}
	
	@GetMapping("/healDashboardData")
	public void healDashboardData() {
		dashboardServiceimpl.healDashboardData();
	}
	
	

}
 