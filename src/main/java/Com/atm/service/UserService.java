package Com.atm.service;

import java.util.List;

import Com.atm.entity.User;

public interface UserService {
	
	User createUser(User user);
	
	 List<User> getAllUsers();
	 
	 void deleteUser(Integer id);

}
