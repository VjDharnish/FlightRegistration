package com.flightticketreservation.login;
import java.util.Scanner;

import com.flightticketreservation.availableflights.AvailableFlightsView;
import com.flightticketreservation.managetickets.ManageTicketsView;
import com.flightticketreservation.managetickets.ManageTicketsViewLoginCallBack;

public class LoginView extends LoginViewCallBack implements LoginSignupCallBack{
	private LoginControllerCallBack loginController;
	private Scanner sc = new Scanner(System.in);
   
	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView loginView = new LoginView();
		loginView.init();
		

	}
	public void  init() {
		System.out.println("---> Welcome to Book My Trip <---");
		System.out.println("--------------------------------------");
		System.out.println("1. Login if Existing User");
		System.out.println("2. Signup if  New User");
		System.out.println("3. Admin Login");
		System.out.println("4.  Exit");
		System.out.println("Enter the option");
		int option = sc.nextInt();
		loginController.loginOptions(option);
		
		
	}

	public void userLogin() {
		System.out.println("Enter your UserName:");
		String username = sc.next();
		System.out.println("Enter your Password:");
		String password = sc.next();
		loginController.checkCredentialOnline(username, password);
		
		

	}

	public void loginSuccess(String username) {
		System.out.println("Hello " + username + " !");
		ManageTicketsViewLoginCallBack manageTicketsView  = new ManageTicketsView(username);
		manageTicketsView.manageOptions();
	}
	

	public void loginFailure(String errorMessage) {
		System.out.println(errorMessage);
		userLogin();
	}

	@Override
	protected void exit() {
		System.out.println("Thank You Visit again ");
		System.exit(0);
		
	}

	@Override
	protected void invalidOption() {
		System.out.println("Please Enter the Correct Option");
		
	}

}