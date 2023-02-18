package com.flightticketreservation.availableflights;

public interface AvailableFlightsModelCallBack {

	void checkFlight(String origin, String destination, String username);


	boolean addFlightDetails(String airlineName, int flightNo, String origin, String destination, String arrivalTime,
			String depatureTime, String duration, int fair, int seatCapacity);


	boolean removeFlight(int flightId);

}
