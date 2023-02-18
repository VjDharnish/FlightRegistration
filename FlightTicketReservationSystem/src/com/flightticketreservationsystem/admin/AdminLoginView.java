package com.flightticketreservationsystem.admin;

import java.util.Scanner;

import com.flightticketreservation.availableflights.AvailableFlightsView;

public class AdminLoginView implements AdminLoginViewCallBack{
	private Scanner sc = new Scanner(System.in);
	private AdminLoginControl adminLoginControl;
	public AdminLoginView() {
		 adminLoginControl= new AdminLoginControl(this);
		
	}

	public void adminEntry() {
		System.out.println("Enter Admin ID");
		String aUser= sc.nextLine();
		
		System.out.println("Enter Passcode");
		String aPassword = sc.nextLine();
		
		adminLoginControl.checkisAdmin(aUser, aPassword);
	}
	
	public void adminLoginSuccess() {
		System.out.println("Hello Admin!");
		AvailableFlightsView availableFlight = new AvailableFlightsView("Admin");
		availableFlight.adminOptions();
	}
	public void adminLoginFail() {
		System.out.println("Fail");
	}
}