package com.flighticketreservation.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dto.*;

public class BookMyTripRepository {
	private static BookMyTripRepository bookMyTripDbInstance;

	private List<Passenger> passenger = new ArrayList<>();
	private List<Flight> flight = new ArrayList<>();
	private List<Credentials> credentials = new ArrayList<>();
	private List<Tickets> tickets = new LinkedList<>();
	private List<User> users = new ArrayList<>();

	private BookMyTripRepository() {

	}

	public static BookMyTripRepository getInstance() {
		if (bookMyTripDbInstance == null) {
			bookMyTripDbInstance = new BookMyTripRepository();
			bookMyTripDbInstance.initialSetup();
		}
		return bookMyTripDbInstance;
	}

	private void initialSetup() {
		credentialSetup();
		flightSetup();
		ticketSetup();

	}

	private void credentialSetup() {
		credentials.add(new Credentials("dharun", "BloodySweet"));
	}

	private void flightSetup() {
		flight.add(new Flight("AirIndia", 34567, "Urapakkam", "Guduvanchery", "12:30", "15:30", "3 hrs", 2, 12000));
		flight.add(new Flight("Indigo", 12098, "Pattukkottai", "Paris", "1:30", "4.00", "2:5 hrs", 5, 10000));
		flight.add(new Flight("AirDeccan", 11111, "Chennai", "Norway", "02:00", "04:00", "2.0 hrs", 10, 10000));

	}

	private void ticketSetup() {
		tickets.add(new Tickets("dharun", "vjdharnish@gmail.com", 11111, "Air Deccan"));
		tickets.add(new Tickets("dharun", "vjdharnish@gmail.com", 12098, "Indigo"));
	}

	public boolean userSetup(String firstName, String lastName, String emailId, long phoneNumber, String password) {
		users.add(new User(firstName, lastName, emailId, phoneNumber));
		credentials.add(new Credentials(firstName, password));
		return true;
	}

	public boolean validateUser(String username, String password) {
		for (Credentials user : credentials) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public Flight checkFlights(String origin, String destination) {
		for (Flight plane : flight) {
			if (plane.getOrigin().equals(origin) && plane.getDestination().equals(destination)) {
				return plane;
			}
		}
		return null;
	}

	public String addPassengerDetails(String firstName, String lastName, String gender, int age, String country,
			long phoneNumber, String emailId, Flight flightDetail) {
		passenger.add(new Passenger(firstName, lastName, gender, age, country, phoneNumber, emailId));
		tickets.add(new Tickets(firstName, emailId, flightDetail.getFlightId(), flightDetail.getAirline()));

		return firstName + " " + lastName;
	}

	public List<Tickets> bookingHistory(String username) {
		List<Tickets> userTickets = new LinkedList<>();
		for (Tickets ticket : tickets) {
			if (ticket.getPassengername().equals(username)) {
				userTickets.add(ticket);
			}
		}
		return userTickets;
	}

	public void cancelTicket(Tickets ticket) {
		tickets.remove(ticket);
	}

	public boolean isValidAdmin(String aUsername, String aPassword) {
		if (aUsername.equals("admin") && aPassword.equals("Mr.Admin")) {
			return true;
		}
		return false;

	}

	public boolean addFlightDetails(String airlineName, int flightNo, String origin, String destination,
			String arrivalTime, String depatureTime, String duration, int fair, int seatCapacity) {
		for(Flight plane:flight) {
			if(flightNo== plane.getFlightId()) {
				
				return false;
			}
		}
		flight.add(new Flight(airlineName,flightNo, origin, destination, arrivalTime,depatureTime,duration,seatCapacity,fair));
		return true;
	}

	public boolean removeFlight(int flightId) {
		for(Flight plane:flight) {
			if(flightId == plane.getFlightId()) {
				flight.remove(plane);
				return true;
			}
		}
		return false;
	}

}
