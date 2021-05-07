package app.dao.abstracts;

import java.util.List;

import app.entities.User;

public interface UserDao {
	
	void save(User user);
	
	void update(User user);
	
	List<User> getAll();
	
	void deleteById(String email);

	User getUserById(String email);

}
