package com.flightticketreservation.managetickets;

import java.util.List;

import com.flightticketreservation.availableflights.AvailableFlightsView;
import com.flightticketreservation.availableflights.FlightsManageController;

import dto.Tickets;
import java.util.Scanner;
public class ManageTicketsController
		implements ManageTicketsControllerViewCallBack, ManageTicketsControllerModelCallBack {
	private ManageTicketsViewCallBack manageTicketsView;
	private ManageTicketsModelCallBack manageTicketsModel;
	private Scanner sc = new Scanner(System.in);
	ManageTicketsController(ManageTicketsViewCallBack manageTicketsView) {
		this.manageTicketsView = manageTicketsView;
		this.manageTicketsModel = new ManageTicketsModel(this);
	}

	@Override
	public void homeOptions(int option,String username) {
		switch(option) {
		case 1:
			FlightsManageController availableFlightsView = new AvailableFlightsView(username);
			availableFlightsView.showFlights();
			break;
		case 2:
			List cancelTickets =manageTicketsModel.showBookingHistory(username);
			manageTicketsView.showBookedTickets(cancelTickets);
		case 3:
			List tickets = manageTicketsModel.showBookingHistory(username);
			manageTicketsView.showBookingHistory(tickets);
			break;
		case 4:
			manageTicketsView.endConsole();
			break;
		default:
			manageTicketsView.invalidOption();
			break;
			
		}
		
		
	}

	@Override
	public void cancelTicket(int option, List<Tickets> cancelTickets) {
		if(option > cancelTickets.size()) {
			manageTicketsView.invalidCancelOption(cancelTickets);
		}
		manageTicketsModel.cancelTicket(cancelTickets.get(option-1));
		
	}

}
