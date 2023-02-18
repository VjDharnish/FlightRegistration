package com.flightticketreservation.booking;

import java.time.LocalTime;

import com.flightticketreservation.managetickets.ManageTicketsBookingViewCallBack;
import com.flightticketreservation.managetickets.ManageTicketsView;

import java.util.Scanner;

import dto.Flight;

public class BookingView implements BookingViewCallBack {
	private BookingControllerViewCallBack bookingController;
	private Scanner sc = new Scanner(System.in);
	private Flight flight;
	private String username;
	public BookingView(Flight flight,String username) {
		this.bookingController = new BookingController(this);
		this.flight = flight;
		this.username =username;
	}

	public void showBookingOption() {
		System.out.println("Enter Travelling Date:");
		String date = sc.next();
		
		   while (true) {   
			System.out.println("Press 1 to  Add Passenger");
			System.out.println("Press 2 to Exit");
			int option = sc.nextInt();
			if(option == 2)
					break;
			System.out.println("Enter Passenger  details\n");
			System.out.println("First Name:");
			String firstName = sc.next();
			System.out.println("Last Name:");
			String lastName = sc.next();
			System.out.println("Gender:");
			String gender = sc.next();
			System.out.println("Age:");
			int age = sc.nextInt();
			System.out.println("Country:");
			String country = sc.next();
			System.out.println("Phone Number:");
			long phoneNumber = sc.nextLong();
			System.out.println("Email Id:");
			String emailId = sc.next();
			bookingController.addPassengerDetails(firstName, lastName, gender, age, country, phoneNumber,emailId,flight);

		}
		bookingController.onboard(date,flight.getArrivalTime());

	}

	public void onboard(LocalTime onboardingTime,String date,String time) {
		System.out
				.println("Your Onboarding on " + flight.getAirline() + " " + flight.getFlightId() + " is Scheduled on " + date + " at " + time);
		System.out.println("Please  check in  early at " + onboardingTime + " " + flight.getAirline() + " counter");
		System.out.println("----->Thank you Visit Again <---");
		ManageTicketsBookingViewCallBack manageTicketsView = new ManageTicketsView(username);
		manageTicketsView.manageOptions();
	}

	@Override
	public void passengerAdded(String passengerName) {
		System.out.println(passengerName + " added SuccessFully\n");

	}

	@Override
	public void passengerNotAdded(String errorMessage) {
		System.out.println(errorMessage);
		showBookingOption();
	}

}
