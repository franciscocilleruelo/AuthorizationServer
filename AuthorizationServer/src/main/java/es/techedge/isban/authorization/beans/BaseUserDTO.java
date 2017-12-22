package es.techedge.isban.authorization.beans;

import java.io.Serializable;

public class BaseUserDTO implements Serializable{

	private static final long serialVersionUID = 8676810075216964659L;
	
	private String username;
	private String password;
	
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
	
	

}
