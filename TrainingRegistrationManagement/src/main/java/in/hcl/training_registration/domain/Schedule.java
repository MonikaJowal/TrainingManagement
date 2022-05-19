package in.hcl.training_registration.domain;

import java.util.Date;

	public class Schedule {
		
		private Long scheduleId;
		private String trainingId;
		private String trainingName;
		private Integer totalNumberOfDays;
		private Date startDate;
		private Date endDate;

		  
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

		public String getTrainingName() {
			return trainingName;
		}

		public void setTrainingName(String trainingName) {
			this.trainingName = trainingName;
		}

		public Integer getTotalNumberOfDays() {
			return totalNumberOfDays;
		}

		public void setTotalNumberOfDays(Integer totalNumberOfDays) {
			this.totalNumberOfDays = totalNumberOfDays;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		
		

}