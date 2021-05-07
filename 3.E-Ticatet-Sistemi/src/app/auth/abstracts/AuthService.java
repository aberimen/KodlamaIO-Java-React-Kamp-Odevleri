package app.auth.abstracts;

import app.entities.User;

public interface AuthService {
	
	boolean authenticate(User user);

}
