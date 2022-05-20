package com.hcl.reportmanagement.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hcl.reportmanagement.domain.Employee;
import com.hcl.reportmanagement.domain.Schedule;
import com.hcl.reportmanagement.domain.Training;
import com.hcl.reportmanagement.domain.TrainingRegistration;
import com.hcl.reportmanagement.domain.User;

public interface ReportService {

	/**
	 * Method findUserByAddress(User[] users) finds list of users who are registered from particular location
	 * @param: Array of User
	 * @return: list of filtered users
	 */
	
	List<User> findUserByAddress(User[] users);

	/**
	 * Method findEmployeeByDesignation(Employee[] employees) finds list of employees based on employeeDesignation
	 * @param: Array of Employee
	 * @return: list of filtered employees by employeedesignation
	 */
	
	List<Employee> findEmployeeByDesignation(Employee[] employees);
	
	/**
	 * Method findEmployeeByDepartment(Employee[] employees) finds list of employees based on employeeDepartment
	 * @param: Array of Employee
	 * @return: list of filtered employees by employeedesignation
	 */
	List<Employee> findEmployeeByDepartment(Employee[] employees);

	
	/**
	 * Method findMonthlySchedule(Schedule[] schedules) finds list of trainings scheduled in a particular month
	 * @param: Array of Schedule
	 * @return: trainings scheduled in the given month
	 */
	
	List<Schedule> findMonthlySchedule(Schedule[] schedules);

	/**
	 * Method listEmployeeByNomination(TrainingRegistration[] registeredEmployees) finds employess nominated for the given program
	 * @param: Array of TrainingRegistration
	 * @return: list of filtered employess nominated for the given program
	 */
	
	List<TrainingRegistration> listEmployeeByNomination(TrainingRegistration[] registeredEmployees);

	
	/**
	 * Method  findTrainingsByStatus(Training[] trainings) finds trainings based on trainingsStatus
	 * @param: Array of Training
	 * @return: list of filtered trainings based on given traininigStatus
	 */

	List<Training> findTrainingsByStatus(Training[] trainings);
	}
