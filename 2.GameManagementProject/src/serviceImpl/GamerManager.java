package serviceImpl;

import domain.Gamer;
import service.GamerService;
import service.UserValidatorService;

public class GamerManager implements GamerService {

	private UserValidatorService userValidatorService;

	public GamerManager(UserValidatorService userValidatorService) {
		this.userValidatorService = userValidatorService;
	}

	@Override
	public void save(Gamer gamer) {
		if(userValidatorService.isValid(gamer)) {
			System.out.println("Kullan�c� Do�ruland�.");
			System.out.println("sisteme eklendi: " + gamer.getFirstName() );
		}else {
			System.out.println("kullan�c� do�rulanamad�.");
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		System.out.println("Kullan�c� g�ncellendi");

	}

	@Override
	public void delete(Gamer gamer) {
		System.out.println("Kullan�c� silindi.");

	}

}
