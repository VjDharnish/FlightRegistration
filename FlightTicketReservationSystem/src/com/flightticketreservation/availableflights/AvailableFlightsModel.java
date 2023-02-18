package com.flightticketreservation.availableflights;

import com.flighticketreservation.repository.BookMyTripRepository;

import dto.Flight;

public class AvailableFlightsModel implements AvailableFlightsModelCallBack {
	private AvailableFlightsControllerModelCallBack availableFlightsController;
	public AvailableFlightsModel(AvailableFlightsControllerModelCallBack availableFlightsController) {
		this.availableFlightsController= availableFlightsController;
	}
	@Override
	public void checkFlight(String origin, String destination,String username) {
		Flight plane =BookMyTripRepository.getInstance().checkFlights(origin,destination);
		if(plane !=null) {
			availableFlightsController.showFlights(plane,username);
		}
		else {
			availableFlightsController.noFlightsAvailable("No Flights Available Right Now!");
		}
	}
	@Override
	public boolean addFlightDetails(String airlineName, int flightNo, String origin, String destination,
			String arrivalTime, String depatureTime, String duration, int fair, int seatCapacity) {
		if(BookMyTripRepository.getInstance().addFlightDetails(airlineName,flightNo, origin, destination, arrivalTime,depatureTime,duration,fair,seatCapacity)) {
			return true;
		}
		return false;
		
	}
	@Override
	public boolean removeFlight(int flightId) {
		if(BookMyTripRepository.getInstance().removeFlight(flightId)) {
			return true;
		}
		return false;
			
		
	}

}
