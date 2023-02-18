package com.flightticketreservation.availableflights;

import dto.Flight;

public interface AvailableFlightsControllerViewCallBack {

	void checkFlight(String origin, String destination, String username);

	void bookOrExit(int option, Flight flight, String username);

	void adminOptions(int option);

	boolean addFlightDetails(String airlineName, int flightNo, String origin, String destination, String arrivalTime,
			String depatureTime, String duration, int fair, int seatCapacity);

	boolean removeFlight(int flightId);

}
