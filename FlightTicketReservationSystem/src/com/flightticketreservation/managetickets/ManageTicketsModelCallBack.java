package com.flightticketreservation.managetickets;

import java.util.List;

import dto.Tickets;

public interface ManageTicketsModelCallBack {

	List showBookingHistory(String username);

	void cancelTicket(Tickets tickets);

}
