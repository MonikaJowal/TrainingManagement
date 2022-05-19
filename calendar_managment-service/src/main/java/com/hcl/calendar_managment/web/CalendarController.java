package com.hcl.calendar_managment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hcl.calendar_managment.domain.Calendar;
import com.hcl.calendar_managment.domain.Schedule;
import com.hcl.calendar_managment.service.CalendarService;
import com.hcl.calendar_managment.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	private CalendarService calendarService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	@Autowired
	private RestTemplate restTemplate;

	
	@GetMapping("/getCalendarById/{calendarId}")
	public ResponseEntity<?> createCalendar(@PathVariable("calendarId") Long calendarId) {
		Calendar calendar = calendarService.getCalendarById(calendarId);
		return new ResponseEntity<Calendar>(calendar,HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/findSchedule/calendarId/{calendarId}")
	public Calendar fetchScheduleByEmployeeId(@PathVariable("calendarId") Long calendarId) {
		Calendar calendar = calendarService.getCalendarById(calendarId);
		List<Schedule> schedules =restTemplate.getForObject("http://schedule-service/schedule/getByScheduleId/" + calendar.getCalendarId(), List.class);
		calendar.setSchedules(schedules);
		return calendar;
	}
	
	@GetMapping("/findAllSchedule")
	public List<Schedule> fetchAllSchedule() {
		List<Schedule> list = restTemplate.getForObject("http://schedule-service/schedule/getAllSchedule", List.class);
		return list;
	}
	
	@GetMapping("/getAllUser")
	public List<Schedule> fetchAllUser() {
		List<Schedule> list = restTemplate.getForObject("http://user-management/user/all", List.class);
		return list;
	}
	

}
