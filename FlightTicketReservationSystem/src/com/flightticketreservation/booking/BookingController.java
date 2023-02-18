package com.flightticketreservation.booking;

import java.text.SimpleDateFormat;
import java.time.LocalTime;

import dto.Flight;

public class BookingController implements BookingControllerModelCallBack, BookingControllerViewCallBack {
	private BookingViewCallBack bookingView;
	private BookingModelCallBack bookingModel;

	BookingController(BookingViewCallBack bookingView) {
		this.bookingView = bookingView;
		this.bookingModel = new BookingModel(this);
	}

	@Override
	public void addPassengerDetails(String firstName, String lastName, String gender, int age, String country,
			long phoneNumber,String emailId,Flight flight) {
		bookingModel.addpassengerDetails(firstName, lastName, gender, age, country, phoneNumber,emailId,flight);

	}

	public void passengerAdded(String passengerName) {
		bookingView.passengerAdded(passengerName);

	}

	@Override
	public void passengerNotAdded(String errorMessage) {
		bookingView.passengerNotAdded(errorMessage);

	}

	@Override
	public void onboard(String date, String time) {
		LocalTime timeFormat = LocalTime.parse(time);
		LocalTime onboardingTime   = timeFormat.minusHours(2);
		bookingView.onboard(onboardingTime, date, time);
	}

}
