package in.hcl.schedule_management.exception;

public class ScheduleNotFoundExceptionResponse {

	private String scheduleNotFound;

	public ScheduleNotFoundExceptionResponse() {
		super();
        // TODO Auto-generated constructor stub
	}

	public ScheduleNotFoundExceptionResponse(String scheduleNotFound) {
		super();
		this.scheduleNotFound = scheduleNotFound;
	}

	public String getScheduleNotFound() {
		return scheduleNotFound;
	}

	public void setScheduleNotFound(String scheduleNotFound) {
		this.scheduleNotFound = scheduleNotFound;
	}

}


