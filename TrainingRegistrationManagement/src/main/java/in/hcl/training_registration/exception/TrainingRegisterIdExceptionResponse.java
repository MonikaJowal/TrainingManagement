package in.hcl.training_registration.exception;

public class TrainingRegisterIdExceptionResponse {
	
	private String employeeId;

	public TrainingRegisterIdExceptionResponse(String employeeId) {
		super();
		this.employeeId = employeeId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	

}