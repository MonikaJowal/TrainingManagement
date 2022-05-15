package in.hcl.training_registration.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class TrainingRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "employeeId is required")
	@Size(max=4,message="Please use 4 characters only")
	@Column(updatable = false, unique = true)
	private String employeeId;
	@NotBlank(message = "employeeName is required")
	private String employeeName;
	@NotBlank(message = "nominatedFor is required")
	private String nominatedFor;	
	private String allottedBatch;
	private String startDate;
	private String endDate;
	
	public TrainingRegistration() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getNominatedFor() {
		return nominatedFor;
	}

	public void setNominatedFor(String nominatedFor) {
		this.nominatedFor = nominatedFor;
	}

	public String getAllottedBatch() {
		return allottedBatch;
	}

	public void setAllottedBatch(String allottedBatch) {
		this.allottedBatch = allottedBatch;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}