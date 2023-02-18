package com.flightticketreservation.signup;

public interface SignupControllerModelCallBack {

	void signupSuccess();

	void signupFailure();

	void addUser(String firstName, String lastName, String emailId, long phoneNumber, String password);

}
