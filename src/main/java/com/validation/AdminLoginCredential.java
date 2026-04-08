package com.validation;

public class AdminLoginCredential {
	private String result;
	public  String validateCredential(String username, String password) {
		if(username.length()<4||username.length()>16) {
			result = "Invalid Username";
		}
		else if(password.length()<4 || password.length()>16){
			result = "Invalid Password";
		}  else {
			result ="Valid";
		}
		return result ;
	}
}
