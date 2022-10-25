package dao;

import entity.UserEntity;

public interface UserDao {

	
	 boolean checkUsername(String username);
	 boolean checkEmail(String email);
	 boolean checkPassword(String password);
	 boolean checkUsernameAndPassword(UserEntity user);
	 int Register(UserEntity user);
}
