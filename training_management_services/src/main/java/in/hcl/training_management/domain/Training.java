package in.hcl.training_management.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String trainerName;
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Training(String name, String contact, String email, String programeName, String trainingStatus,
			String trainingtype, Integer noOfTraining, String averagerating, Double budget, String batchNo,
			String trainerName) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.programeName = programeName;
		this.trainingStatus = trainingStatus;
		this.trainingtype = trainingtype;
		this.noOfTraining = noOfTraining;
		this.averagerating = averagerating;
		this.budget = budget;
		this.batchNo = batchNo;
		this.trainerName = trainerName;
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
