package in.hcl.user_management.service;

import in.hcl.user_management.domain.User;
import in.hcl.user_management.web.Status;

public interface UserService {
	
	public User RegisterUser(User user);
	public Status loginUser(User user);
	public Status logoutUser(User user);
	public Status changePassword(User user);
	public Status updateProfile(User user);
}
