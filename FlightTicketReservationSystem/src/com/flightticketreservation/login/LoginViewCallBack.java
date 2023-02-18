package com.flightticketreservation.login;


public abstract class LoginViewCallBack {
	abstract void loginSuccess(String username);
	abstract void loginFailure(String errorMessage);
	protected abstract void userLogin();
	protected abstract void exit();
	protected abstract void invalidOption();

}