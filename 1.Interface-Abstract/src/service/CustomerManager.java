package service;

import domain.Customer;

public abstract class CustomerManager implements CustomerService { // abstract class olduðu için instance oluþturulamaz.
	@Override
	public void save(Customer customer) {

		System.out.println("veritabanýna kaydedildi: " + customer.getFirstName());

	}

}
