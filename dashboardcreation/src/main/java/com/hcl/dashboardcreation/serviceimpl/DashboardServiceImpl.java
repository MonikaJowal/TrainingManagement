package com.hcl.dashboardcreation.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hcl.dashboardcreation.domain.Dashboard;
import com.hcl.dashboardcreation.repository.DashboardRepository;
import com.hcl.dashboardcreation.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {
	@Autowired
	public DashboardRepository dashboardRepository;

	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public int totalTrainings() {
		int total=0;
		List<Dashboard> list=dashboardRepository.findAll();
		if(list!=null && list.size()>0) {
			Dashboard dashboard=list.get(0);
			total=dashboard.getTotalTranining_no();
		}
		return total;
	}

	@Override
	public double averageRating() {
		double average=0;
		List<Dashboard> list=dashboardRepository.findAll();
		if(list!=null && list.size()>0) {
			Dashboard dashboard=list.get(0);
			average=dashboard.getAverage_rating();
		}
		return average;
	}

	@Override
	public double totalTrainingHrs() {
		double training_hours=0;
		List<Dashboard> list=dashboardRepository.findAll();
		if(list!=null && list.size()>0) {
			Dashboard dashboard=list.get(0);
			training_hours=dashboard.getTotalTraining_hr();
		}
		return training_hours;
	}

	@Override
	public double budget() {
		double budget=0;
		List<Dashboard> list=dashboardRepository.findAll();
		if(list!=null && list.size()>0) {
			Dashboard dashboard=list.get(0);
			budget=dashboard.getBudget();
		}
		return budget;
	}

	@Override
	public String trainingType() {
		String trainingType="";
		List<Dashboard> list=dashboardRepository.findAll();
		if(list!=null && list.size()>0) {
			Dashboard dashboard=list.get(0);
			trainingType=dashboard.getTraining_type();
		}
		return trainingType;
	}

	@Override
	public String trainingStatus() {
		String trainingStatus="";
		List<Dashboard> list=dashboardRepository.findAll();
		if(list!=null && list.size()>0) {
			Dashboard dashboard=list.get(0);
			trainingStatus=dashboard.getTraining_status();
		}
		return trainingStatus;
	}

	@Override
	public String monthlyTrainingView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void healDashboardData() {
		List<Dashboard>list=dashboardRepository.findAll();
		Dashboard dashboard=null;
		if(list!=null && list.size()>0) 
			dashboard=list.get(0);
		else
			dashboard=new Dashboard();
		int totalNoTraining=restTemplate.getForObject("http://contact-service/totalNoTraining/", Integer.class);
		double training_hr=restTemplate.getForObject("http://contact-service/training_hr/", Double.class);
		String training_status =restTemplate.getForObject("http://contact-service/training_status/", String.class);
		String training_type=restTemplate.getForObject("http://contact-service/training_type/", String.class);
		double budget=10000;
		double averageRating=50;
		dashboard.setTotalTranining_no(totalNoTraining);
		dashboard.setAverage_rating(averageRating);
		dashboard.setBudget(budget);
		dashboard.setTotalTraining_hr(training_hr);
		dashboard.setTraining_status(training_status);
		dashboard.setTraining_type(training_type);
		dashboardRepository.save(dashboard);
	}

}
