package com.flightticketreservationsystem.admin;

import com.flighticketreservation.repository.BookMyTripRepository;

public class AdminLoginModel implements AdminLoginModelCallBack{
	private AdminLoginControlViewCallBack admincontrol;
	
	public AdminLoginModel(AdminLoginControl adminLoginControl) {
		this.admincontrol = adminLoginControl;
	}

	public boolean isAdmin(String aUsername,String aPassword) {
		if(BookMyTripRepository.getInstance().isValidAdmin(aUsername, aPassword)) {
			return true;
		}
		return false;
	}

}