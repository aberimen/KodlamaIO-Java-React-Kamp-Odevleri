package app.business.service;

import java.util.List;

import app.entities.User;

public interface UserService{
	
	void deleteUser(User user);
	
	void updateUser(User user);
	
	void login(String email, String password);
	
	void register(User user);
	
	List<User> getUsers();
	
	void deleteUserById(String email);

	User getUserById(String email);
	
	

	

}
