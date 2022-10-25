package service;

import jakarta.servlet.http.HttpSession;

public interface UserService {
	
	 String doLogin(String username, String password,HttpSession session);
	 String doRegister(String username,String password,String email,HttpSession session);
	
}
