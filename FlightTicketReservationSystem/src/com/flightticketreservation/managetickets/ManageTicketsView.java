package com.flightticketreservation.managetickets;

import java.util.List;
import java.util.Scanner;

import dto.Tickets;

public class ManageTicketsView
		implements ManageTicketsViewCallBack, ManageTicketsViewLoginCallBack, ManageTicketsBookingViewCallBack {
	private ManageTicketsControllerViewCallBack ticketsController;
	private Scanner sc = new Scanner(System.in);
	private String username;
	

	public ManageTicketsView(String username) {
		this.ticketsController = new ManageTicketsController(this);
		this.username = username;
	}

	public ManageTicketsView() {

	}

	public void manageOptions() {
		System.out.println("\n--> Welcome to BookMyTrip <--");
		System.out.println("-----------------------------------");
		System.out.println("Press 1 to Book Tickets");
		System.out.println("Press 2 to Cancel Tickets");
		System.out.println("Press 3 to Booking History");
		System.out.println("Press 4 to Exit");
		int option = sc.nextInt();
		ticketsController.homeOptions(option, username);

	}

	@Override
	public void showBookingHistory(List<Tickets> tickets) {
		System.out.println("\n--->BOOKING HISTORY <---\n");
		System.out.println("PassengerName\t\t Ticket ID\t\t\t\t\t \tFlight ID\t\t AIRLINE");
		for (Tickets ticket : tickets) {
			System.out.println(ticket.getPassengername() + "\t\t\t" + ticket.getTicketId() + "\t\t"
					+ ticket.getFlightId() + "\t\t" + ticket.getAirlineName());

		}
		manageOptions();
	}

	@Override
	public void invalidOption() {
		System.out.println("Invalid Option Try Again");
		manageOptions();
	}

	@Override
	public void endConsole() {
		System.out.println("--->THANK YOU VISIT AGAIN<---");
		System.exit(0);
	}

	@Override
	public void showBookedTickets(List<Tickets> cancelTickets) {
		System.out.println("\nBooked Tickets\n");
		System.out.println("S.No\t Ticket ID\t\t\t\t\t  Flight ID\t\t AIRLINE");
		int ticketNum = 1;
		for (Tickets ticket : cancelTickets) {
			System.out.println(ticketNum++ + "\t " + ticket.getTicketId() + "\t\t" + ticket.getFlightId() + "\t\t"
					+ ticket.getAirlineName());
		}
		System.out.println("Select TICKET No  to Cancel and Select -1 to Home Page");
		int option = sc.nextInt();
		if (option == -1) {
			manageOptions();
		}
		ticketsController.cancelTicket(option, cancelTickets);
		cancelTickets.remove(option - 1);
		showBookedTickets(cancelTickets);

	}

	@Override
	public void invalidCancelOption(List<Tickets> cancelTickets) {
		System.out.println("Invalid Option Please Try Again");
		showBookedTickets(cancelTickets);
		
		
	}

}
