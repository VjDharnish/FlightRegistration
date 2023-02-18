package com.flightticketreservation.signup;

import java.util.Scanner;

import com.flightticketreservation.login.LoginSignupCallBack;
import com.flightticketreservation.login.LoginView;

public class SignupView implements SignupViewCallBack,SignupLoginCallBack {
	private SignupControllerViewCallBack signupController;
	private Scanner sc = new Scanner(System.in);
	private LoginSignupCallBack loginView;
	public SignupView() {
		this.signupController = new SignupController(this);
		this.loginView = new LoginView();
	}
	public void signupInit() {
		System.out.println("\nEnter details\n");
		System.out.println("Enter First Name:");
		String  firstName= sc.next();
		System.out.println("Enter Last Name");
		String lastName = sc.next();
		System.out.println("Enter Email Id");
		String emailId = sc.next();
		System.out.println("Enter Phone Number:");
		long phoneNumber = sc.nextLong();
		enterPassword( firstName, lastName, emailId,phoneNumber);		
	}
	private void enterPassword(String  firstName,String lastName,String emailId,long phoneNumber) {
		System.out.println("Enter Password:");
		String password = sc.next();
		System.out.println("Enter Password Again ");
		String confirmPassword = sc.next();
		if(!password.equals(confirmPassword)) {
			System.out.println("Password Mismatch");
			enterPassword(firstName, lastName, emailId,phoneNumber);
		}
		signupController.addUser(firstName, lastName, emailId,phoneNumber, password);
		
	}
	@Override
	public void signupSuccess() {
		System.out.println("Sign up SuccessFull");
		loginView.userLogin();
		
	}
	@Override
	public void signupFailure() {
		System.out.println("Sign up Failed Please Try Again!");
		loginView.userLogin();
		
	}
	

}
