package com.flightticketreservation.availableflights;

import dto.Flight;

public interface AvailableFlightsViewCallBack {

	void showAvailableFlights(Flight plane, String username);

	void noFlightAvailable(String noFlightMessage);

	void showFlights();

	void addFlight();

	void removeFlight();

	void exit();

	void invalidOption();

}
