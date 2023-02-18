package com.flightticketreservation.managetickets;

import java.util.List;

import dto.Tickets;

public interface ManageTicketsViewCallBack {

	void showBookingHistory(List<Tickets> tickets);

	void endConsole();

	void invalidOption();

	void showBookedTickets(List<Tickets> cancelTickets);

	void invalidCancelOption(List<Tickets> cancelTickets);


}
