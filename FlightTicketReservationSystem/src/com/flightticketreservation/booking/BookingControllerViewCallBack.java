package com.flightticketreservation.booking;

import dto.Flight;

public interface BookingControllerViewCallBack {

	void onboard(String date, String string);

	void addPassengerDetails(String firstName, String lastName, String gender, int age, String country,
			long phoneNumber, String emailId, Flight flight);

}
