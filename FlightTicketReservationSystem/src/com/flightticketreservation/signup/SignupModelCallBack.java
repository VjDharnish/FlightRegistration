package com.flightticketreservation.signup;

public interface SignupModelCallBack {

	void addUser(String firstName, String lastName, String emailId, long phoneNumber, String password);

}
