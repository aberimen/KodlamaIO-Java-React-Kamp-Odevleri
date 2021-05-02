package serviceimpl;

import domain.Customer;
import service.CustomerManager;
import service.NationalIdentityCheckService;

public class StarbucksCustomerManager extends CustomerManager {

	private final NationalIdentityCheckService idChecker;

	public StarbucksCustomerManager(NationalIdentityCheckService idChecker) {
		this.idChecker = idChecker;
	}
	

	@Override
	public void save(Customer customer) {
		boolean isValid = idChecker.verifyIdentiy(customer);
		
		if(isValid) {
			System.out.println("Müþteri veritabanýna eklendi: " + customer.getFirstName());
		}else {
			System.err.println("Bir hata oluþtu.");
		}

	}

}
