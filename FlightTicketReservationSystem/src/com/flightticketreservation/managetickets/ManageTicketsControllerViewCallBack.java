package com.flightticketreservation.managetickets;

import java.util.List;

import dto.Tickets;

public interface ManageTicketsControllerViewCallBack {

	void homeOptions(int option, String username);

	void cancelTicket(int option, List<Tickets> cancelTickets);

}
