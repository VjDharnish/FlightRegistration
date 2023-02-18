package com.flightticketreservation.booking;

import java.time.LocalTime;

public interface BookingViewCallBack {

	void passengerNotAdded(String errorMessage);

	void passengerAdded(String passengerName);

	void onboard(LocalTime onboardingTime, String date, String time);

}
