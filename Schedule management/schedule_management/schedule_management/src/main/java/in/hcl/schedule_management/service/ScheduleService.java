package in.hcl.schedule_management.service;

import java.util.List;

import in.hcl.schedule_management.domain.Schedule;

public interface ScheduleService {
	public Schedule createSchedule(Schedule schedule);
    public Schedule getScheduleById(Long employeeid);
    public void deleteScheduleById(Long employeeid);
    public List<Schedule> getAllSchedule();
    public Schedule updateSchedule(Schedule schedule, Long employeeid);

}
