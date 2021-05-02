package adapters;

import domain.Customer;
import service.NationalIdentityCheckService;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements NationalIdentityCheckService {

	@Override
	public boolean verifyIdentiy(Customer customer) {
		try {
			KPSPublicSoap client = new KPSPublicSoapProxy();
			
			boolean isValid = client.TCKimlikNoDogrula(Long.valueOf(customer.getNotionalId()),
					 customer.getFirstName().toUpperCase(),customer.getLastName().toUpperCase(),customer.getDateOfBirth().getYear());
			return isValid;
		} catch (Exception e) {
			
			System.out.println("Servis Hata oluþtu:" + e.getMessage());
		}
		
		return false;
	}

}
