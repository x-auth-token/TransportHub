package com.pl.transporthub.transporthub.controllers;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Set;

import com.pl.transporthub.transporthub.baseclasses.GUIAbstractApplicationWindowController;
import com.pl.transporthub.transporthub.views.GUIAdminView;
import com.pl.transporthub.transporthub.views.GUIAuthenticatedUsersView;
import com.pl.transporthub.transporthub.views.GUIMainWindowView;
import com.pl.transporthub.user.User;

public class GUIAuthenticatedUsersController extends GUIAbstractApplicationWindowController {

	private GUIMainWindowController mainWindowController;
	private GUIAuthenticatedUsersView authUsersView;
	private GUIAdminController adminController;
	private User user;


	public GUIAuthenticatedUsersController(User user) {

		this.user = user;
	}

	@Override
	public void setMouseListeners() { 

		super.setMouseListeners();

		authUsersView.getBtnLogout().addMouseListener(new MouseListener() {

			@Override public void mouseReleased(MouseEvent e) {
			}
			@Override public void mousePressed(MouseEvent e) {
				user.setAuthenticated(false);
				authUsersView.hideAppWindow();
				authUsersView.closeAppWindow();
				mainWindowController = new GUIMainWindowController();
				mainWindowController.start();
			}

			@Override public void mouseExited(MouseEvent e) { 
			}

			@Override public void mouseEntered(MouseEvent e) { 

			}

			@Override public void mouseClicked(MouseEvent e) { 
			} 

		});



	}



	

	@Override 
	public void start() {
		
		generateViewByRole(user);
	}

	public void generateViewByRole(User user) {

		switch (user.getRole()) {
		case PASSENGER:
			authUsersView = new GUIAuthenticatedUsersView();
			setMouseListeners();
			authUsersView.showAppWindow();
			break;


		case DRIVER:
			;
		case PTM:
			;
		case ADMIN:
			adminController = new GUIAdminController(user);
			adminController.start();
			break;
		default:
			break;
		}
	}

	public void whoHasFocus() {
		System.out.println("the owner is:" +  authUsersView.getAppFrame().getFocusOwner());
	}
}



