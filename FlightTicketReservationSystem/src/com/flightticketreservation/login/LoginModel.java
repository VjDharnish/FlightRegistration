package com.flightticketreservation.login;

import com.flighticketreservation.repository.BookMyTripRepository;

public class LoginModel extends LoginModelCallBack {
	private LoginModelControllerCallBack loginController;

	LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController = loginController;
	}

	public void checkCredential(String username, String password) {
		if (BookMyTripRepository.getInstance().validateUser(username, password)) {
			loginController.loginSuccess(username);
		} else
			loginController.loginFailure("Invalid Credentials!");
	}

	interface LoginModelControllerCallBack {
		void loginSuccess(String username);

		void loginFailure(String errorMessage);
	}

}