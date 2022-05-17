package in.hcl.training_registration.exception;

public class EmployeeIdExceptionResponse {
	
	private String employeeId;

	public EmployeeIdExceptionResponse(String employeeId) {
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