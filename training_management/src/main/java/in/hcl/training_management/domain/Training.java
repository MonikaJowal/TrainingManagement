package in.hcl.training_management.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Training {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String contact;
	private String email;
	private String Coursename;
	private String trainingststus;
	private String trainingtype;
	private int nooftraining;
	private String averagerating;
	private double budget;
	private String Batchno;
	
	private String trainername;
	
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getBatchno() {
		return Batchno;
	}
	public void setBatchno(String batchno) {
		this.Batchno = batchno;
	}
	public String getTrainingststus() {
		return trainingststus;
	}
	public void setTrainingststus(String trainingststus) {
		this.trainingststus = trainingststus;
	}
	public String getTrainingtype() {
		return trainingtype;
	}
	public void setTrainingtype(String trainingtype) {
		this.trainingtype = trainingtype;
	}
	public int getNooftraining() {
		return nooftraining;
	}
	public void setNooftraining(int nooftraining) {
		this.nooftraining = nooftraining;
	}
	public String getAveragerating() {
		return averagerating;
	}
	public void setAveragerating(String averagerating) {
		this.averagerating = averagerating;
	}
	public String getTrainername() {
		return trainername;
	}
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCoursename() {
		return Coursename;
	}
	public void setCoursename(String coursename) {
		Coursename = coursename;
	}
	public Training() {
		super();
	}


}
