package app.auth.concretes;

import app.auth.abstracts.AuthService;
import app.entities.User;

public class GoogleAuth implements AuthService{

	@Override
	public boolean authenticate(User user) {
		System.out.println("Google ile giri� yap�ld�");
		return true;
	}

}
