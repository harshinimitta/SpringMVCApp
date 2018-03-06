package com.vu.jee;

public class LoginService1 {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("Harshini") && password.equals("villanova");
	}

}