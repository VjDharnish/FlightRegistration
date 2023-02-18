package com.flightticketreservation.booking;

import dto.Flight;

public interface BookingModelCallBack {

	void addpassengerDetails(String firstName, String lastName, String gender, int age, String country,
			long phoneNumber,String emailId, Flight flight);

}
