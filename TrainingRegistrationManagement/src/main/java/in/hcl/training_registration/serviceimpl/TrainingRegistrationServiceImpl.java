package in.hcl.training_registration.serviceimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import in.hcl.training_registration.domain.TrainingRegistration;
import in.hcl.training_registration.exception.EmployeeIdException;
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
		try {
			trainingRegistration.setEmployeeId(trainingRegistration.getEmployeeId());
		return trainingRegistrationRepository.save(trainingRegistration);
		}catch(Exception ex){
			throw new EmployeeIdException("Employee with id :"+trainingRegistration.getEmployeeId()+" already nominated for "
		+trainingRegistration.getNominatedFor()+" training");
			
		}
	}

	@Override
	public TrainingRegistration findTrainingRegistrationByEmployeeId(String empId) {
		TrainingRegistration trainingRegistration = trainingRegistrationRepository.findRegistrationByEmployeeId(empId);
		if(trainingRegistration == null) {
			throw new EmployeeIdException("Employee with Id :"+empId+" not registered or nominated for the training");
		}
		return trainingRegistration;
	}	
	
	@Override
	public Iterable<TrainingRegistration> findAllTrainingRegistration() {
	
		return trainingRegistrationRepository.findAll();
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<TrainingRegistration> findEmployeeByNominatedForFullStack( String nominatedFor, String allottedBatch) {
	
	   String sql = "select * from training_registration where nominated_for = ' "+nominatedFor+"' "+"OR"+" allotted_batch = "+"'"+allottedBatch+"'";
	return jdbcTemplate.query(sql,new Object[] {},new RowMapper<TrainingRegistration>(){
         public TrainingRegistration mapRow(ResultSet rs, int row) throws SQLException {
        	 TrainingRegistration fullStackEmployees =new TrainingRegistration();
        	 fullStackEmployees.setId(rs.getLong(1));
        	 fullStackEmployees.setEmployeeId(rs.getString("employee_id"));
        	 fullStackEmployees.setEmployeeName(rs.getString("employee_name"));
        	 fullStackEmployees.setNominatedFor(rs.getString("nominated_for"));
        	 fullStackEmployees.setAllottedBatch(rs.getString("allotted_batch"));				
				return fullStackEmployees;
				}
				});	
	
	}

	}