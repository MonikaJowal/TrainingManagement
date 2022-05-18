package com.hcl.calendar_managment.exception;

public class CalendarNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalendarNotFoundException(){
		super();
	}
	
	public CalendarNotFoundException(String message){
		super(message);
	}

}
