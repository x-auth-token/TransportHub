package com.pl.transporthub.transporthub.controllers;



import com.pl.transporthub.transporthub.baseclasses.GUIAbstractApplicationWindowController;
import com.pl.transporthub.transporthub.views.GUIAdminView;
import com.pl.transporthub.transporthub.views.GUIAuthenticatedUsersView;
import com.pl.transporthub.user.User;

public class GUIAuthenticatedUsersController extends GUIAbstractApplicationWindowController {


	private GUIAuthenticatedUsersView authUsersView;
	private GUIAdminView adminView;
	private User user;


	public GUIAuthenticatedUsersController(User user) {
		super();
		this.user = user;
	}

	@Override 
	public void setMouseListeners() { 
		super.setMouseListeners(); }


	@Override 
	public void start() {

		generateViewByRole(user); 
	}

	public void generateViewByRole(User user) {

		switch (user.getRole()) {
		case PASSENGER:
			authUsersView = new GUIAuthenticatedUsersView();
			authUsersView.showAppWindowView();
		
			
		case DRIVER:
			;
		case PTM:
			;
		case ADMIN:
			adminView = new GUIAdminView();
			adminView.showAppWindowView();

		default:
			break;
		}
	}
}



