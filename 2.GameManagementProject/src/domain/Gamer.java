package domain;

import java.time.LocalDate;

public class Gamer extends User{

	public Gamer() {
		super();
	}

	public Gamer(long id, String firstName, String lastName, LocalDate dateOfBirth, String nationalId) {
		super(id, firstName, lastName, dateOfBirth, nationalId);
	}
	
}
