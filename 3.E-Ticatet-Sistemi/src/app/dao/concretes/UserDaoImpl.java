package app.dao.concretes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import app.dao.abstracts.UserDao;
import app.entities.User;

public class UserDaoImpl implements UserDao{
	
	private  Map<String,User> userDatabase = new HashMap<>();

	@Override
	public void save(User user) {
		userDatabase.put(user.getEmail(),user);
		System.out.println("Kullanýcý veritabanýna kaydedildi: " + user.getFirstName());
		
	}
	
	@Override
	public List<User> getAll() {

		return  userDatabase.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
	}


	@Override
	public void update(User user) {
		userDatabase.put(user.getEmail(),user);
		
	}

	@Override
	public void deleteById(String email) {
		userDatabase.remove(email);
		
	}

	@Override
	public User getUserById(String email) {
		
		return userDatabase.get(email);
	}



	
}
