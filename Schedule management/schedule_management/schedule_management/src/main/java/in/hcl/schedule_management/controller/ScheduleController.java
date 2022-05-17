package in.hcl.schedule_management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.schedule_management.domain.Schedule;
import in.hcl.schedule_management.service.ScheduleService;

@RestController
@RequestMapping("/employees")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	public Schedule getSchedule(@PathVariable("employeeId")Long employeeId) {
		return scheduleService.getScheduleById(employeeId);
	}
}


    