package com.flightticketreservation.signup;

public interface SignupControllerViewCallBack {

	void addUser(String firstName, String lastName, String emailId, long phoneNumber, String password);

}
