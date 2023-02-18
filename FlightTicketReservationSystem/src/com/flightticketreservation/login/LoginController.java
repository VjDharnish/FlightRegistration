package com.flightticketreservation.login;
import com.flightticketreservation.signup.SignupLoginCallBack ;
import com.flightticketreservation.signup.SignupView ;
import com.flightticketreservationsystem.admin.AdminLoginView;
import com.flightticketreservation.login.LoginModel.LoginModelControllerCallBack;

public class LoginController extends LoginControllerCallBack implements LoginModelControllerCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	LoginController(LoginViewCallBack loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);

	}
	@Override
	public void loginOptions(int option) {
		switch(option) {
		case 1:
			loginView.userLogin();
			break;
		case 2:
			SignupLoginCallBack signupView = new SignupView();
			signupView.signupInit();
			break;
		case 3:
			AdminLoginView adminLogin = new AdminLoginView();
			adminLogin.adminEntry();
			break;
		case 4:
			loginView.exit();
			break;
		default:
			loginView.invalidOption();
			break;
		}
		
		
	}

	public void checkCredentialOnline(String username, String password) {
		loginModel.checkCredential(username, password);
	}

	public void loginSuccess(String username) {
		loginView.loginSuccess(username);
	}

	public void loginFailure(String errorMessage) {
		loginView.loginFailure(errorMessage);
	}

	

}