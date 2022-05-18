package com.hcl.calendar_managment.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.calendar_managment.domain.Calendar;
import com.hcl.calendar_managment.domain.Schedule;
import com.hcl.calendar_managment.service.CalendarService;
import com.hcl.calendar_managment.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api")
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@Autowired
	private RestTemplate restTemplate;

	
	@GetMapping("/findSchedule/{employeeId}")
	public String fetchScheduleByEmployeeId(@PathVariable("employeeId") Long employeeId) {
		Schedule schedule = restTemplate.exchange("http://localhost:9095/employees"+"/"+employeeId, HttpMethod.GET,null,Schedule.class).getBody();
		System.out.println(schedule);
		return restTemplate.exchange("http://localhost:9095/employees"+"/"+employeeId, HttpMethod.GET,null,String.class).getBody();
	}
	
	@GetMapping("/findAllSchedule")
	public String fetchAllSchedule() {
		return restTemplate.exchange("http://localhost:9095/employees/getAll", HttpMethod.GET,null,String.class).getBody();
	}
	
	@GetMapping("/getAllUser")
	public String fetchAllUser() {
		return restTemplate.exchange("http://127.0.0.1:8081/user/all", HttpMethod.GET,null,String.class).getBody();
	}
	@PostMapping("/create")
	public ResponseEntity<?> createNewCalendar(@Valid @RequestBody Calendar calendar, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Calendar calen = calendarService.createCalendar(calendar);
		return new ResponseEntity<Calendar>(calen, HttpStatus.CREATED);
	}

	@DeleteMapping("/{calendarId}")
	public Calendar getCalendarById(@PathVariable("calendarId") Long calandarId) {
		return calendarService.getCalendarById(calandarId);
	}
	
	@PatchMapping("/updateCalendar/{calendarId}")
	public Calendar getCalendarById(@RequestBody Calendar calendar, @PathVariable("calendarId") Long calandarId) {
		return calendarService.updateCalendar(calendar, calandarId);
	}
	
	@GetMapping("/getAll")
	public List<Calendar> getCalendarList() {
		return calendarService.getAllCalendar();
	}
	
}
