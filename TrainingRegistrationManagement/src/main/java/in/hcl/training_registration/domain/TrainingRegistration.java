package in.hcl.training_registration.domain;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

@Entity
public class TrainingRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="registration_id")
	private Long registrationId;
	@Column(updatable = false, unique = true)
    private Long socialSecurityNo;
	@Column(updatable = false, unique = true)

	private Long scheduleId;
	private String nominatedFor;	
	private String allottedBatch;
	
	private Date createdAt;
	private Date updatedAt;
	
//	@Transient
//	List<Employee>employees;
//	@Transient
//	List<Schedule>schedule;	
	@Transient
	private Employee employee;
	@Transient
	private Schedule schedule;
	
	
	public TrainingRegistration() {
		super();
	}

	public TrainingRegistration(Long socialSecurityNo, Long scheduleId) {
		super();
		this.socialSecurityNo = socialSecurityNo;
		this.scheduleId = scheduleId;
	}

	public Long getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Long registrationId) {
		this.registrationId = registrationId;
	}

	

	public Long getSocialSecurityNo() {
		return socialSecurityNo;
	}

	public void setSocialSecurityNo(Long socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
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

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
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