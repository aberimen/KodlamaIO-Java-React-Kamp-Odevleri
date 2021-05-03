package serviceImpl;

import domain.User;
import service.UserValidatorService;

public class UserValidatorWithEDevlet implements UserValidatorService{

	@Override
	public boolean isValid(User user) {
		if(user.getFirstName().toUpperCase().equals("ABDURRAHMAN") && user.getNationalId().equals("123456789")) {
			return true;
		}
		return false;
	}

}
