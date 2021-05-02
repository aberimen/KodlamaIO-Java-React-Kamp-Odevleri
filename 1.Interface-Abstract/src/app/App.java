package app;

import java.time.LocalDate;

import adapters.MernisServiceAdapter;
import domain.Customer;
import service.CustomerManager;
import service.NationalIdentityCheckService;
import serviceimpl.NeroCustomerManager;
import serviceimpl.StarbucksCustomerManager;

public class App {

	public static void main(String[] args) {

		Customer customer = new Customer("Abdurrahman", "Berimen", LocalDate.of(1997, 11, 11), "1321545");

		NationalIdentityCheckService idChecker = new MernisServiceAdapter();
		CustomerManager starbucksCustomerManager = new StarbucksCustomerManager(idChecker);
		starbucksCustomerManager.save(customer);

		CustomerManager neroCustomerManager = new NeroCustomerManager();
		neroCustomerManager.save(customer);
	}

}
