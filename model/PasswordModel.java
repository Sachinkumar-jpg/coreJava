package model;

import java.io.Serializable;

public class PasswordModel implements Serializable {
   private static final long serialVersionUID = 1L;
	String password;
	public PasswordModel(String password) {
		this.password = password;
	}
	public PasswordModel() {
		
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
