package app.auth.concretes;

import app.auth.abstracts.VerifyService;
import app.entities.User;

public class EmailVerifier implements VerifyService{

	@Override
	public boolean verify(User user) {
		System.out.println("Doðrulama kodu gönderildi");
		
		System.out.println("E mail doðrulandý");
		return true;
	}

}
