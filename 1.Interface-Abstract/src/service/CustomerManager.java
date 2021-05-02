package service;

import domain.Customer;

public abstract class CustomerManager implements CustomerService { // abstract class oldu�u i�in instance olu�turulamaz.
	@Override
	public void save(Customer customer) {

		System.out.println("veritaban�na kaydedildi: " + customer.getFirstName());

	}

}
