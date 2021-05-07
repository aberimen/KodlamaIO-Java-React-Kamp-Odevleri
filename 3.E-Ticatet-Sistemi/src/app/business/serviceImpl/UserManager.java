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
		
		if(userDao.getUserById(email) != null ) { // kullanýcý zaten varsa
			System.out.println("Hata : Bu email baþkasý tarafýndan kullanýlýyor");
			return;
		}
		
		if (password.length() < 6) {
			System.out.println("Hata : Þifre en az 6 karakterden oluþmalý");

		} else if (!emailValidator.isValid(email)) {
			System.out.println("Hata : Geçersiz email formatý");

		} else if (firstName.length() < 2 || lastName.length() < 2) {
			System.out.println("Hata : Isim veya soyisim en az 2 karakterden oluþmalý");
		} else {
			verifyService.verify(user);
			userDao.save(user);
		}

	}

	@Override
	public void login(String email, String password) {
		User indb = userDao.getUserById(email); // kullanýcýnýn veritabanýndan çekilmesi

		if (!email.isEmpty() && !password.isEmpty()) {

			if (indb == null) { // kullanýcý veritabanýnda yoksa
				System.out.println("Kullanýcý kayýtlý deðil");
				return;
			}

			if (authService.authenticate(userDao.getUserById(email))) { // dýþ servis ile kimlik doðrulamasý , örn.
																		// Google
				System.out.println("Sisteme hoþ geldiniz.");
			} else {
				System.out.println("Hata : Doðrulama baþarýsýz");
			}

		} else {
			System.out.println(" Hata : email, þifre boþ olamaz");
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
