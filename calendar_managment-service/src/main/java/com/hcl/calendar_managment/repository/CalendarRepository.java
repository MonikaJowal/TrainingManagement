package com.hcl.calendar_managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.calendar_managment.domain.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

	public Calendar findByCalendarId(Long calendarId);
}
