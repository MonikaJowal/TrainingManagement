package in.hcl.training_registration.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import in.hcl.training_registration.domain.TrainingRegistration;
import in.hcl.training_registration.exception.TrainingRegisterIdException;
import in.hcl.training_registration.repository.TrainingRegistrationRepository;
import in.hcl.training_registration.service.TrainingRegistrationService;
@Service
public class TrainingRegistrationServiceImpl implements TrainingRegistrationService {
	
	@Autowired
	private TrainingRegistrationRepository trainingRegistrationRepository;
	
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate  jdbcTemplate;
	private Connection conn = null;
	  private Statement stmt = null;
	
	@Override
	public TrainingRegistration saveOrUpdate(TrainingRegistration trainingRegistration) {

		return trainingRegistrationRepository.save(trainingRegistration);
	}
	@Override
	public Optional<TrainingRegistration> findTrainingRegistrationById(Long trainingResgistrationId) {
		Optional<TrainingRegistration> trainingRegistration = trainingRegistrationRepository.findById(trainingResgistrationId);

		if(trainingRegistration == null) {
			throw new TrainingRegisterIdException("Registration with Id :"+trainingResgistrationId+" does not exist");
		}
		return trainingRegistration;
	}	
	
	@Override
	public Iterable<TrainingRegistration> findAllTrainingRegistration() {
	
		return trainingRegistrationRepository.findAll();
	}	

	@Override
	public void deleteTrainingRegistrationById(Long id) {
		Optional<TrainingRegistration> trainingRegistration = trainingRegistrationRepository.findById(id);
		if(trainingRegistration == null) {
			throw  new TrainingRegisterIdException("TrainingRegistration with TrainingRegistration Id: "+id+" Does not Exist");
		}
		trainingRegistrationRepository.delete(trainingRegistration.get());
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<TrainingRegistration> findEmployeeByNominatedForCourse(String nominatedFor, String allottedBatch) {
		 String sql = "select * from training_registration where nominated_for = ' "+nominatedFor+"' "+"OR"+" allotted_batch = "+"'"+allottedBatch+"'";
			return jdbcTemplate.query(sql,new Object[] {},new RowMapper<TrainingRegistration>(){
		         public TrainingRegistration mapRow(ResultSet rs, int row) throws SQLException {
		        	 TrainingRegistration fullStackEmployees =new TrainingRegistration();
		        	 fullStackEmployees.setScheduleId(rs.getLong("schedule_id"));
		        	 fullStackEmployees.setSocialSecurityNo(rs.getLong("social_security_no"));
		        	 fullStackEmployees.setNominatedFor(rs.getString("nominated_for"));
		        	 fullStackEmployees.setAllottedBatch(rs.getString("allotted_batch"));				
						return fullStackEmployees;
						}
						});	
			
			}
	}

	