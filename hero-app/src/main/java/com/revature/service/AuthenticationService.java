package com.revature.service;

public class AuthenticationService {

	public static boolean isValidUser(String username, String password) {
		if(username != null && password != null) {
			return (username.equals("PoppyCorn") && password.equals("Pass123$"));
		} else {
			return false;
		}
	}
	
}
