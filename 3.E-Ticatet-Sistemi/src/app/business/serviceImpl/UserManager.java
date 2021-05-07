package app.business.serviceImpl;

import java.util.List;

import app.auth.abstracts.AuthService;
import app.auth.abstracts.VerifyService;
import app.business.service.UserService;
import app.dao.abstracts.UserDao;
import app.entities.User;
import app.util.EmailValidator;


public class UserManager implements UserService {

	private UserDao userDao;
	private EmailValidator emailValidator;
	private AuthService authService;
	private VerifyService verifyService;

	public UserManager(UserDao userDao, AuthService authService, VerifyService verifyService) {
		this.userDao = userDao;
		this.authService = authService;
		this.verifyService = verifyService;
		this.emailValidator = new EmailValidator();
	}

	@Override
	public void register(User user){
		
		String firstName = user.getFirstName();
		String lastName  = user.getLastName();
		String email =user.getEmail();
		String password = user.getPassword();
		
		if(userDao.getUserById(email) != null ) { // kullan�c� zaten varsa
			System.out.println("Hata : Bu email ba�kas� taraf�ndan kullan�l�yor");
			return;
		}
		
		if (password.length() < 6) {
			System.out.println("Hata : �ifre en az 6 karakterden olu�mal�");

		} else if (!emailValidator.isValid(email)) {
			System.out.println("Hata : Ge�ersiz email format�");

		} else if (firstName.length() < 2 || lastName.length() < 2) {
			System.out.println("Hata : Isim veya soyisim en az 2 karakterden olu�mal�");
		} else {
			verifyService.verify(user);
			userDao.save(user);
		}

	}

	@Override
	public void login(String email, String password) {
		User indb = userDao.getUserById(email); // kullan�c�n�n veritaban�ndan �ekilmesi

		if (!email.isEmpty() && !password.isEmpty()) {

			if (indb == null) { // kullan�c� veritaban�nda yoksa
				System.out.println("Kullan�c� kay�tl� de�il");
				return;
			}

			if (authService.authenticate(userDao.getUserById(email))) { // d�� servis ile kimlik do�rulamas� , �rn.
																		// Google
				System.out.println("Sisteme ho� geldiniz.");
			} else {
				System.out.println("Hata : Do�rulama ba�ar�s�z");
			}

		} else {
			System.out.println(" Hata : email, �ifre bo� olamaz");
		}

	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteById(user.getEmail());

	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);

	}

	@Override
	public List<User> getUsers() {
		return userDao.getAll();
	}

	@Override
	public void deleteUserById(String email) {
		userDao.deleteById(email);
		
	}

	@Override
	public User getUserById(String email) {
		
		return userDao.getUserById(email);
	}


}
