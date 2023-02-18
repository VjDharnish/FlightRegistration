package com.flightticketreservation.signup;

import com.flighticketreservation.repository.BookMyTripRepository;

public class SignupModel implements SignupModelCallBack{
	private SignupControllerModelCallBack signupController;
	public SignupModel(SignupControllerModelCallBack signupController) {
		this.signupController=signupController;
	}
	@Override
	public void addUser(String firstName, String lastName, String emailId, long phoneNumber, String password) {
		boolean flag = BookMyTripRepository.getInstance().userSetup(firstName, lastName, emailId,phoneNumber,password);
		if(flag) {
			signupController.signupSuccess();
		}
		else {
			signupController.signupFailure();
		}
	}

}
