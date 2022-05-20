package com.hcl.reportmanagement.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.scheduling.config.ScheduledTasksBeanDefinitionParser;
import org.springframework.stereotype.Service;

import com.hcl.reportmanagement.domain.Employee;
import com.hcl.reportmanagement.domain.Schedule;
import com.hcl.reportmanagement.domain.Training;
import com.hcl.reportmanagement.domain.TrainingRegistration;
import com.hcl.reportmanagement.domain.User;
import com.hcl.reportmanagement.service.ReportService;


/**
 * 
 * @author MAheswari M
 *
 */
@Service
public class ReportServiceImpl implements ReportService {

	

	public List<User> findUserByAddress(User[] users) {
		String address = "Mumbai";
		List<User> usersByAddress = new ArrayList<>();
		for (User user : users) {
			if (user.getAddress().equals(address)) {
				usersByAddress.add(user);
			}
		}
		return usersByAddress;

	}

	
	
	@Override
	public List<Employee> findEmployeeByDesignation(Employee[] employees) {
		String designation = "hr";
		List<Employee> employeeByDesignation = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getEmployeeDesignation().equals(designation)) {
				employeeByDesignation.add(employee);
			}
		}
		return employeeByDesignation;
	}
	
	@Override
	public List<Employee> findEmployeeByDepartment(Employee[] employees) {
		String department = "Admin";
		List<Employee> employeeByDepartment = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getemployeeDepartment().equals(department)) {
				employeeByDepartment.add(employee);
			}
		}
		return employeeByDepartment;
	}

	

	@Override
	public List<Schedule> findMonthlySchedule(Schedule[] schedules) {
		String startDate = "2022/06/00";
		String endDate = "2022-06-30";
		List<Schedule> monthlySchedule = new ArrayList<>();
		for (Schedule schedule : schedules) {
			String schduleStartDate = schedule.getStartDate().toString();
			String schduleEndDate = schedule.getEndDate().toString();
			if (startDate.compareTo(schduleStartDate) == 1) {
				if (endDate.compareTo(schduleEndDate) == -1) {
					monthlySchedule.add(schedule);
				}
			}
		}
		return monthlySchedule;
	}

	
	
	public List<TrainingRegistration> listEmployeeByNomination(TrainingRegistration[] registeredEmployees) {
		String nominatedfor = "Traning orientation";
		List<TrainingRegistration> registerdEmployeeByNomination = new ArrayList<>();
		for (TrainingRegistration employee : registeredEmployees) {
			if (employee.getNominatedFor().equals(nominatedfor)) {
				registerdEmployeeByNomination.add(employee);
			}
		}
		return registerdEmployeeByNomination;
	}
	
	
	@Override
	public List<Training> findTrainingsByStatus(Training[] trainings) {
		String trainingStatus = "completed";
		List<Training> trainingByStatus = new ArrayList<>();
		for (Training training : trainings) {
			if (training.getTrainingStatus().equals(trainingStatus)) {
				trainingByStatus.add(training);
			}
		}
		return trainingByStatus;
	}



	
}
