package domain;

import java.time.LocalDate;

public class Customer {

	private long id;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String notionalId;

	public Customer(String firstName, String lastName, LocalDate dateOfBirth, String notionalId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.notionalId = notionalId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNotionalId() {
		return notionalId;
	}

	public void setNotionalId(String notionalId) {
		this.notionalId = notionalId;
	}

}
