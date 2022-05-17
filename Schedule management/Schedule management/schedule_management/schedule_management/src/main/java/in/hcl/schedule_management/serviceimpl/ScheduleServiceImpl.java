package in.hcl.schedule_management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hcl.schedule_management.domain.Schedule;
import in.hcl.schedule_management.exception.ScheduleNotFoundException;
import in.hcl.schedule_management.repository.ScheduleRepository;
import in.hcl.schedule_management.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public Schedule createSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	@Override
	public Schedule getScheduleById(Long employeeId) {
		Optional<Schedule> schedule = scheduleRepository.findById(employeeId);
		if(schedule.isPresent()) {
			return schedule.get();
		}else {
			throw new ScheduleNotFoundException("Schedule not found with id : " + employeeId);
		}
			
	}

	@Override
	public void deleteScheduleById(Long employeeId) {
		Optional<Schedule> schedule = scheduleRepository.findById(employeeId);
		if(schedule.isPresent()) {
			scheduleRepository.delete(schedule.get());
		}else {
			throw new ScheduleNotFoundException("Schedule not found with id : " + employeeId);
		}
		
		
	}

	@Override
	public List<Schedule> getAllSchedule() {
		return scheduleRepository.findAll();
	}

	@Override
	public Schedule updateSchedule(Schedule schedule) {
		Optional<Schedule> schedule2 = scheduleRepository.findById(schedule.getEmployeeId());
		if(schedule2.isPresent()) {
			Schedule updatedSchedule = schedule2.get();
			updatedSchedule.setEmployeeId(schedule.getEmployeeId());
			updatedSchedule.setEmployeeName(schedule.getEmployeeName());
			updatedSchedule.setProgrameName(schedule.getProgrameName());
			updatedSchedule.setStartDate(schedule.getStartDate());
			updatedSchedule.setEndDate(schedule.getEndDate());
			return scheduleRepository.save(updatedSchedule);
		}else {
			throw new ScheduleNotFoundException("Schedule not found with id : " + schedule.getEmployeeId());
		}
		
	}
}
	


