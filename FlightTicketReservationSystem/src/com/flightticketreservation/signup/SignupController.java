package com.flightticketreservation.signup;

public class SignupController implements SignupControllerViewCallBack,SignupControllerModelCallBack{
	private SignupViewCallBack signupView;
	private SignupModelCallBack signupModel; 
	public SignupController(SignupViewCallBack signupView) {
		this.signupView= signupView;
		this.signupModel= new SignupModel(this);
	}
	@Override
	public void addUser(String firstName, String lastName, String emailId, long phoneNumber, String password) {
		signupModel.addUser(firstName, lastName, emailId,phoneNumber, password);
		
	}
	@Override
	public void signupSuccess() {
		signupView.signupSuccess();
		
	}
	@Override
	public void signupFailure() {
		signupView.signupFailure();
		
	}
	
}
