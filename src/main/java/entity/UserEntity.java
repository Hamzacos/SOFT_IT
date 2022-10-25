package entity;

import java.io.Serializable;
import util.MD5Util;

public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String email;
	
	public UserEntity(){}

	public UserEntity(String username, String password) {
		this.username = username;
		this.password = MD5Util.hashPassword(password);
	}
	
	public UserEntity(String username, String email, String password, Integer state, String code) {
        this.username = username;
        this.email = email;
        this.password = MD5Util.hashPassword(password);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
