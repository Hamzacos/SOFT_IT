package service;


import entity.UserEntity;
import dao.UserDao;
import dao.UserImpl;
import jakarta.servlet.http.HttpSession;

public class UserserviceImpl implements UserService {
		
	private UserImpl  userImpl = new UserImpl ();
	@Override
	public String doLogin(String username, String password, HttpSession session) {
		String msg;
		UserEntity user = new UserEntity(username,password);
		if(userImpl.checkUsernameAndPassword(user)) {
			
			session.setAttribute(username, user.getUsername());
			msg = "connexion réussie";
			return msg;
			}
		 if (userImpl.checkUsername(user.getUsername())) {
	            msg = "Échec de la connexion mot de passe";
	            return msg;
	        }
	        msg = "l'utilisateur n'existe pas";
	        return msg;
		}
	@Override
	public String doRegister(String username, String password, String email, HttpSession session) {
		System.out.println("doRegiseter from service iml called");

		String msg;
		
//		if(!email.matches("\"^\\\\w+@(\\\\w+\\\\.)+\\\\w+$\"")) {
//			msg = "Le format de l'e-mail est incorrect";
//			return msg;
//		}
//		
//		if(userImpl.checkUsername(username)) {
//			msg = "ce email existe deja";
//			return msg;
//		}
//		
//		if(userImpl.checkEmail(email)) {
//			msg = "ce email existe deja";
//			return msg;
//		}
		
		UserDao userDao=new UserImpl();
		UserEntity user=new UserEntity();
		user.setEmail(email);
		user.setUsername(username);
		user.setPassword(password);
		int insertedUserId=userDao.Register(user);
		if(insertedUserId>1) {
			msg="user inserted successfully";
		}else
			msg = "L'inscription a échoué, veuillez vérifier Vos informations ";
		return msg;
	}
}
