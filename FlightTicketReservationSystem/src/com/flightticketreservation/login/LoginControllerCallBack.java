package com.flightticketreservation.login;

public abstract class LoginControllerCallBack {
	abstract void checkCredentialOnline(String username, String password);

	public abstract void loginOptions(int option) ;
}
