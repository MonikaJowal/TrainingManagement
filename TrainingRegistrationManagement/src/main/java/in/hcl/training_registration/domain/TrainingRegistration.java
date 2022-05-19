package in.hcl.training_registration.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class TrainingRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registrationId;
//  @NotBlank(message = "employeeId is required")
//	@Size(max=4,message="Please use 4 characters only")
//	@Column(updatable = false, unique = true)
    private Long employeeId;
	private Long scheduleId;
	private String nominatedFor;	
	private String allottedBatch;
	
	private Date createdAt;
	private Date updatedAt;
	
	@Transient
	List<Employee>employees;
	@Transient
	List<Schedule>schedule;		
	
	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getNominatedFor() {
		return nominatedFor;
	}

	public void setNominatedFor(String nominatedFor) {
		this.nominatedFor = nominatedFor;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}
	

	public String getAllottedBatch() {
		return allottedBatch;
	}

	public void setAllottedBatch(String allottedBatch) {
		this.allottedBatch = allottedBatch;
	}

	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();
		
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}



	

}