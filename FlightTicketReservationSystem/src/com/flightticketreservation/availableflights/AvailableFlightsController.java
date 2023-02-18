package com.flightticketreservation.availableflights;

import com.flightticketreservation.booking.BookingView;
import com.flightticketreservation.login.LoginView;

import dto.*;

public class AvailableFlightsController
		implements AvailableFlightsControllerViewCallBack, AvailableFlightsControllerModelCallBack {
	private AvailableFlightsViewCallBack availableFlightsView;
	private AvailableFlightsModelCallBack availableFlightsModel;

	public AvailableFlightsController(AvailableFlightsViewCallBack availableFlightsView) {
		this.availableFlightsView = availableFlightsView;
		this.availableFlightsModel = new AvailableFlightsModel(this);
	}

	public void checkFlight(String origin, String destination,String username) {
		availableFlightsModel.checkFlight(origin,destination,username);
	}

	@Override
	public void showFlights(Flight plane,String username) {
		availableFlightsView.showAvailableFlights(plane,username);
		
	}

	@Override
	public void noFlightsAvailable(String noFlightMessage) {
		availableFlightsView.noFlightAvailable(noFlightMessage);
		
	}

	@Override
	public void bookOrExit(int option,Flight flight,String username) {
		switch(option) {
		case 1: 
			BookingView bookingView = new BookingView(flight,username);
			bookingView.showBookingOption();
			break;
		case 2:
			System.out.println("Thank you Visit Again");
			System.exit(0);
			
		}
		
	}

	@Override
	public void adminOptions(int option) {
		switch(option) {
		case 1:
			availableFlightsView.addFlight();
			break;
		case 2:
			availableFlightsView.removeFlight();
			break;
		case 3:
			LoginView loginView = new LoginView();
			loginView.init();
			break;
		case 4:
			availableFlightsView.exit();
		default:
			availableFlightsView.invalidOption();
		}
		
	}

	@Override
	public boolean addFlightDetails(String airlineName, int flightNo,String origin, String destination, String arrivalTime,
			String depatureTime, String duration, int fair, int seatCapacity) {
		if(availableFlightsModel.addFlightDetails(airlineName,flightNo, origin, destination, arrivalTime,depatureTime,duration,fair,seatCapacity)){
			return true;
		}
		return false;
		
	}

	@Override
	public boolean  removeFlight(int flightId) {
		if(availableFlightsModel.removeFlight(flightId)) {
			return true;
		}
		return false;
		
	}

}
