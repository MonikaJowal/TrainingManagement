package in.hcl.training_registration.domain;

	import java.util.Date;

import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.Size;
	@Entity
	public class Schedule {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		  private Long scheduleId;
//		@NotBlank(message = "scheduleId is required")
//		@Size(max=4,message="Please use 4 characters only")
//		@Column(updatable = false, unique = true)
		  private String trainingId;
		  private Integer totalNumberDays;
	      private Date StartDtate;
	      private Date EndDate;
	      private  Date createdAt;
		  private Date updatedAt;
		  
		  
		public Schedule() {
			super();
		}
			
		public Long getScheduleId() {
			return scheduleId;
		}
		public void setScheduleId(Long scheduleId) {
			this.scheduleId = scheduleId;
		}
		public String getTrainingId() {
			return trainingId;
		}
		public void setTrainingId(String trainingId) {
			this.trainingId = trainingId;
		}
		public Integer getTotalNumberDays() {
			return totalNumberDays;
		}
		public void setTotalNumberDays(Integer totalNumberDays) {
			this.totalNumberDays = totalNumberDays;
		}
		public Date getStartDtate() {
			return StartDtate;
		}
		public void setStartDtate(Date startDtate) {
			StartDtate = startDtate;
		}
		public Date getEndDate() {
			return EndDate;
		}
		public void setEndDate(Date endDate) {
			EndDate = endDate;
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
