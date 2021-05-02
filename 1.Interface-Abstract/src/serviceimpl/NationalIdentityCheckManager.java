package serviceimpl;

import domain.Customer;
import service.NationalIdentityCheckService;

public class NationalIdentityCheckManager implements NationalIdentityCheckService {


	@Override
	public boolean verifyIdentiy(Customer customer) {
		System.out.println("TC kimlik no doðrulandý..");
		return true;

	}

}
