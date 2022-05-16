package com.hcl.calendar_managment.service;

import java.util.List;

import com.hcl.calendar_managment.domain.Calendar;

public interface CalendarService {

	public Calendar createCalendar(Calendar calendar);
	public Calendar getCalendarById(Long calendarid);
	public void deleteCalendarById(Long calendarid);
	public List<Calendar> getAllCalendar();
	public Calendar updateCalendar(Calendar calendar, Long id);
}
