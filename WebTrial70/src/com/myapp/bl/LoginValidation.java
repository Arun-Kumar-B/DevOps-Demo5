package com.myapp.bl;
public class LoginValidation {
	
	public boolean validateLogin(String userName, String pwd) {
		boolean validUser = true;
			if(userName.equalsIgnoreCase("test") && pwd.equalsIgnoreCase("test")) {
				return validUser;
			}
			else {
				return false;
			}
	}
	
}
