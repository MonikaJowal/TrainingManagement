package in.hcl.training_management.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Training {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trainingId;
	private String name;
	private String contact;
	private String email;
	private String programeName;
	private String trainingStatus;
	private String trainingtype;
	private Integer noOfTraining;
	private String averagerating;
	private Double budget;
	private String batchNo;
	private String duration;
	private Date start_date;
	private Date end_date;
	private Long socialSecurityNo;
	private String trainerName;
	
	

	@Transient
	private Employee employee ;
	

	
	
	public Training() {
		super();
	}

	
	
	public Training(Long trainingId, Long socialSecurityNo, String trainerName) {
		super();
		this.trainingId = trainingId;
		this.socialSecurityNo = socialSecurityNo;
		this.trainerName = trainerName;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Long getSocialSecurityNo() {
		return socialSecurityNo;
	}


	public void setSocialSecurityNo(Long socialSecurityNo) {
		this.socialSecurityNo = socialSecurityNo;
	}


	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Long getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(Long trainingId) {
		this.trainingId = trainingId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgrameName() {
		return programeName;
	}
	public void setProgrameName(String programeName) {
		this.programeName = programeName;
	}
	public String getTrainingStatus() {
		return trainingStatus;
	}
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}
	public String getTrainingtype() {
		return trainingtype;
	}
	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}
	public Integer getNoOfTraining() {
		return noOfTraining;
	}
	public void setNoOfTraining(Integer noOfTraining) {
		this.noOfTraining = noOfTraining;
	}
	public String getAveragerating() {
		return averagerating;
	}
	public void setAveragerating(String averagerating) {
		this.averagerating = averagerating;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	
}
