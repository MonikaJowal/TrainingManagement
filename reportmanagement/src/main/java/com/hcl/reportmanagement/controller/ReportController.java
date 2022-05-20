package com.hcl.reportmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.reportmanagement.domain.Employee;
import com.hcl.reportmanagement.domain.Schedule;
import com.hcl.reportmanagement.domain.Training;
import com.hcl.reportmanagement.domain.TrainingRegistration;
import com.hcl.reportmanagement.domain.User;
import com.hcl.reportmanagement.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RestTemplate restTemplate1;

	@GetMapping("userreport/user/all")
	public ResponseEntity<?> getUserReport() {
		List<User> users = restTemplate.getForObject("http://user-management/user/all", List.class);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@GetMapping("userreportbyaddress/user/all")
	public ResponseEntity<List<User>> getUserByAddressReport() {
		// List<User> users = new ArrayList<>();
		User[] users = restTemplate.getForObject("http://user-management/user/all", User[].class);
		return new ResponseEntity<List<User>>(reportService.findUserByAddress(users), HttpStatus.OK);
	}

	@GetMapping("employeereport/employee/getAll")
	public ResponseEntity<?> getEmployeeReport() {
		List<Employee> employees = restTemplate.getForObject("http://employee-management/employee/getAll", List.class);
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("employeereportByDesignation/employee/getAll")
	public ResponseEntity<?> getEmployeeReportByDesignation() {
		Employee[] employees = restTemplate.getForObject("http://employee-management/employee/getAll",
				Employee[].class);
		return new ResponseEntity<List<Employee>>(reportService.findEmployeeByDesignation(employees), HttpStatus.OK);
	}
	
	@GetMapping("employeereportByDepartment/employee/getAll")
	public ResponseEntity<?> getEmployeeReportByDepartment() {
		Employee[] employees = restTemplate.getForObject("http://employee-management/employee/getAll",Employee[].class);
		return new ResponseEntity<List<Employee>>(reportService.findEmployeeByDepartment(employees), HttpStatus.OK);
	}
	

	@GetMapping("scheduleReport/schedule/all")
	public ResponseEntity<?> getScheduleReport() {
		List<Schedule> schedules = restTemplate.getForObject("http://schedule-management/schedule/all", List.class);
		return new ResponseEntity<List<Schedule>>(schedules, HttpStatus.OK);
	}

	@GetMapping("scheduleReportByMonthwise/schedule/all")
	public ResponseEntity<?> getScheduleReportByMonthwise() {
		Schedule[] schedules = restTemplate.getForObject("http://schedule-management/schedule/all", Schedule[].class);
		return new ResponseEntity<List<Schedule>>(reportService.findMonthlySchedule(schedules), HttpStatus.OK);
	}

	@GetMapping("registeredemployeereport/trainingregistration/registeredemployees")
	public ResponseEntity<?> getRegisterdEmployeeReport() {
		List<TrainingRegistration> trainingRegistration = restTemplate
				.getForObject("http://registrationmanagement/trainingregistration/registeredemployees", List.class);
		return new ResponseEntity<List<TrainingRegistration>>(trainingRegistration, HttpStatus.OK);
	}

	@GetMapping("registeredemployeereport/trainingregistration/registeredemployees/nominatedfor")
	public ResponseEntity<?> getRegisterdEmployeeReportByNomination() {
		TrainingRegistration[] registeredEmployees = restTemplate.getForObject(
				"http://registrationmanagement/trainingregistration/registeredemployees", TrainingRegistration[].class);
		return new ResponseEntity<List<TrainingRegistration>>(
				reportService.listEmployeeByNomination(registeredEmployees), HttpStatus.OK);
	}

	@GetMapping("trainingreport/training/getAll")
	public ResponseEntity<?> geTrainingReport() {
		List<Training> trainings = restTemplate.getForObject("http://training_management/training/getAll", List.class);
		return new ResponseEntity<List<Training>>(trainings, HttpStatus.OK);
	}
	
	@GetMapping("trainingReportByStatus/training/getAll")
	public ResponseEntity<?> geTrainingReportByStatus() {
		Training[] trainings = restTemplate.getForObject("http://training_management/training/getAll", Training[].class);
		return new ResponseEntity<List<Training>>(reportService.findTrainingsByStatus(trainings), HttpStatus.OK);
	}

}
