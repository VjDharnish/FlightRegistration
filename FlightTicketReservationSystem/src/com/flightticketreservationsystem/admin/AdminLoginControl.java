package com.flightticketreservationsystem.admin;

public class AdminLoginControl implements AdminLoginControlViewCallBack{
	
	private AdminLoginViewCallBack adminLoginView;
	private AdminLoginModelCallBack adminLoginModel;
	public AdminLoginControl(AdminLoginViewCallBack adminLoginView) {
		this.adminLoginView= adminLoginView;
		this.adminLoginModel = new AdminLoginModel(this);	
	}

	public void checkisAdmin(String aUsername,String aPassword) {
		if(adminLoginModel.isAdmin(aUsername, aPassword)) {
			adminLoginView.adminLoginSuccess();
		}
		else {
			adminLoginView.adminLoginFail();
		}
	}

}
