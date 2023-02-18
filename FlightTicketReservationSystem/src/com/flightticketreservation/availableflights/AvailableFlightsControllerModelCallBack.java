package com.flightticketreservation.availableflights;

import dto.Flight;

public interface AvailableFlightsControllerModelCallBack {


	void noFlightsAvailable(String string);

	void showFlights(Flight plane, String username);





}
