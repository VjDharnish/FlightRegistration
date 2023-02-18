package com.flightticketreservation.managetickets;

import java.util.List;

import com.flighticketreservation.repository.BookMyTripRepository;

import dto.Tickets;

public class ManageTicketsModel implements ManageTicketsModelCallBack {
	private ManageTicketsControllerModelCallBack  manageTicketsController;
	public ManageTicketsModel(ManageTicketsControllerModelCallBack manageTicketsController) {
		// TODO Auto-generated constructor stub
		this.manageTicketsController=manageTicketsController;
	}
	@Override
	public List showBookingHistory(String username) {
		List bookedTickets = BookMyTripRepository.getInstance().bookingHistory(username);
		return bookedTickets;
	}
	@Override
	public void cancelTicket(Tickets ticket) {
		BookMyTripRepository.getInstance().cancelTicket(ticket);		
	}

}
