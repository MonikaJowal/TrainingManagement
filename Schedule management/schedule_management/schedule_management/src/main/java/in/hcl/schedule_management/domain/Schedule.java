package in.hcl.schedule_management.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Schedule {
	@NotBlank(message="name id required")
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotBlank(message="employeeId id required")
	private Long employeeId;
	@NotBlank(message="coursename id required")
	private String courseName;
	@JsonFormat(pattern="dd/mm/yyyy")
	private Date startName;
	@JsonFormat(pattern="dd/mm/yyyy")
	private Date endDate;
	@JsonFormat(pattern="dd/mm/yyyy")
	private Date createdAt;
	@JsonFormat(pattern="dd/mm/yyyy")
	private Date updatedAt;
	
	
	public Schedule(String name, @NotBlank(message = "employeeId id required") Long employeeId,
			@NotBlank(message = "coursename id required") String courseName, Date startName, Date endDate,
			Date createdAt, Date updatedAt) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.courseName = courseName;
		this.startName = startName;
		this.endDate = endDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartName() {
		return startName;
	}

	public void setStartName(Date startName) {
		this.startName = startName;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

}
