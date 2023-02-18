package com.flightticketreservation.availableflights;

import java.util.Scanner;

import dto.Flight;

public class AvailableFlightsView implements AvailableFlightsViewCallBack, FlightsManageController {
	private Scanner sc = new Scanner(System.in);
	private AvailableFlightsControllerViewCallBack availableFlightsController;
	private String username;

	public AvailableFlightsView(String username) {
		this.availableFlightsController = new AvailableFlightsController(this);
		this.username = username;
	}

	public void showFlights() {
		System.out.println("Welcome to  Booking Page");
		System.out.println("Enter Origin:");
		String origin = sc.next();
		System.out.println("Enter Destination:");
		String destination = sc.next();
		availableFlightsController.checkFlight(origin, destination, username);
	}

	@Override
	public void showAvailableFlights(Flight plane, String username) {
		System.out.println("Airline Name -" + plane.getAirline());
		System.out.println("Flight No        -" + plane.getFlightId());
		System.out.println("Origin            -" + plane.getOrigin() + " ---- " + plane.getArrivalTime());
		System.out.println("Destination    -" + plane.getDestination() + " ---- " + plane.getDepatureTime());
		System.out.println("Duration        -" + plane.getDuration());
		System.out.println("Total Fair       -" + plane.getFairDetatils());

		System.out.println("Press 1 to Book Tickets");
		System.out.println("Press 2 to Exit");
		int option = sc.nextInt();
		availableFlightsController.bookOrExit(option, plane, username);

	}

	@Override
	public void noFlightAvailable(String noFlightMessage) {
		System.out.println(noFlightMessage);
		showFlights();
	}

	public void adminOptions() {
		System.out.println("Press 1 to Add Flight");
		System.out.println("Press 2 to Remove Flight");
		System.out.println("Press 3 to Back to login");
		System.out.println("Press 4 to Exit");
		int option = sc.nextInt();
		availableFlightsController.adminOptions(option);
	}

	@Override
	public void addFlight() {
		System.out.println("Enter Flight Details");
		System.out.println("--------------------");
		System.out.println("Enter Airline Name");
		String airlineName = sc.next();
		System.out.println("Enter Flight number");
		int flightNo = sc.nextInt();
		System.out.println("Enter the origin");
		String origin = sc.next();
		System.out.println("Enter Destination");
		String destination = sc.next();
		System.out.println("Enter Arrival Time");
		String arrivalTime = sc.next();
		System.out.println("Enter Depature Time");
		String depatureTime = sc.next();
		System.out.println("Enter Travel Duration");
		String duration = sc.next();
		System.out.println("Enter the Fare amount");
		int fair = sc.nextInt();
		System.out.println("Enter No of Available Seats");
		int seatCapacity = sc.nextInt();
		if(availableFlightsController.addFlightDetails(airlineName, flightNo, origin, destination, arrivalTime,
				depatureTime, duration, fair, seatCapacity)) {
			System.out.println("Flight Added Successfully");
		}
		else {
			System.out.println("Flight Already Available");
		}
		adminOptions();
	
	}

	@Override
	public void removeFlight() {
		System.out.println("Enter Flight ID:");
		int flightId = sc.nextInt();
		if (availableFlightsController.removeFlight(flightId)) {
			System.out.println("Flight Removed SuccessFully");
		} else {
			System.out.println("No Flightt Available With this Flight Id");
		}
		adminOptions();

	}

	@Override
	public void exit() {
		System.out.println("Bye Bye Admin!");
		System.exit(0);

	}

	@Override
	public void invalidOption() {
		System.err.println("Drink a cup of Tea and Press the Correct Option Admin");
		adminOptions();

	}

}
