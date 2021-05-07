package app.auth.abstracts;

import app.entities.User;

public interface VerifyService {
	
	boolean verify(User user);

}
