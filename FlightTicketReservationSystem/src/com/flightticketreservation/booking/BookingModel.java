package com.flightticketreservation.booking;

import com.flighticketreservation.repository.BookMyTripRepository;

import dto.Flight;

public class BookingModel implements BookingModelCallBack {
	private BookingControllerModelCallBack bookingController;

	BookingModel(BookingControllerModelCallBack bookingController) {
		this.bookingController = bookingController;
	}

	public void addpassengerDetails(String firstName, String lastName, String gender, int age, String country,
			long phoneNumber,String emailId,Flight flight) {
		String passengerName = BookMyTripRepository.getInstance().addPassengerDetails(firstName, lastName, gender, age,
				country, phoneNumber,emailId,flight);
		if (passengerName != null) {
			bookingController.passengerAdded(passengerName);
		} else {
			bookingController.passengerNotAdded("Invalid Passenger Details Please fill up Again");
		}
	}

}
