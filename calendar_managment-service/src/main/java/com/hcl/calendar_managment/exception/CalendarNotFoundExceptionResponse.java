package com.hcl.calendar_managment.exception;

public class CalendarNotFoundExceptionResponse {

	private String calendarNotFound;

	public CalendarNotFoundExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalendarNotFoundExceptionResponse(String calendarNotFound) {
		super();
		this.calendarNotFound = calendarNotFound;
	}

	public String getCalendarNotFound() {
		return calendarNotFound;
	}

	public void setCalendarNotFound(String calendarNotFound) {
		this.calendarNotFound = calendarNotFound;
	}
	
	
}
