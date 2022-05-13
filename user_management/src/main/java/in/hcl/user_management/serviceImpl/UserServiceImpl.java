package in.hcl.user_management.serviceImpl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import in.hcl.user_management.domain.User;
import in.hcl.user_management.exception.UserIdException;
import in.hcl.user_management.repository.UserRepository;
import in.hcl.user_management.service.UserService;
import in.hcl.user_management.web.Status;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	@Override
	public User RegisterUser(User user) {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new UserIdException("User ID "+user.getId()+" already exist");
		}
	}

	@Override
	public Status loginUser(User u) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if ((user.getUsername()).equals(u.getUsername()) && (user.getPassword()).equals(u.getPassword())) {
				return Status.LOGIN_SUCCESS;
			}
			else if(((user.getUsername())!=(u.getUsername()) && (user.getPassword()).equals(u.getPassword()))) {
				return Status.USERNAME_NOT_CORRECT;
			}
			else if(((user.getUsername()).equals(u.getUsername()) && (user.getPassword())!=(u.getPassword()))) {
				return Status.PASSWORD_NOT_CORRECT;
			}
		}
		return Status.USERNAME_AND_PASSWORD_NOT_CORRECT;
	}

	@Override
	public Status logoutUser(User u) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if ((user.getUsername()).equals(u.getUsername()) && (user.getPassword()).equals(u.getPassword())) {
				return Status.LOGOUT_SUCCESS;
			}
		}
		return Status.USERNAME_AND_PASSWORD_NOT_CORRECT;
	}

	@Override
	public Status changePassword(User u) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if((user.getUsername()).equals(u.getUsername())) {
				String sql = "update user set password = '"+u.getPassword()+"' where username = '"+u.getUsername()+"'";
				jdbcTemplate.setDataSource(dataSource);
				//System.out.println("Password updated successfully");
				jdbcTemplate.update(sql);
				return Status.PASSWORD_UPDATED_SUCCESSFULLY;
			}
		}
		return Status.USERNAME_NOT_FOUND;
	}

	@Override
	public Status updateProfile(User u) {
		String sql = "update user set username = '"+u.getUsername()+"', address = '"+u.getAddress()+"', mobile_no = '"+u.getMobileNo()+"', password = '"+u.getPassword()+"' where id = '"+u.getId()+"'";
		jdbcTemplate.setDataSource(dataSource);
		//System.out.println("Profile updated successfully");
		jdbcTemplate.update(sql);
		return Status.PROFILE_UPDATED_SUCCESSFULLY;
	}
}
