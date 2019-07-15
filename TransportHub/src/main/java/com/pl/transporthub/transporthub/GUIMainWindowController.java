package com.pl.transporthub.transporthub;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.pl.transporthub.aaa.AuthenticationController;
import com.pl.transporthub.transporthub.baseclasses.GUIAbstractApplicationWindowController;
import com.pl.transporthub.transporthub.baseclasses.GUICustomCloseApplication;
import com.pl.transporthub.user.User;

public class GUIMainWindowController extends GUIAbstractApplicationWindowController {

	private GUIMainWindowView mainWindowView;

	// private GUICustomCloseApplication closeApplication;

	private AuthenticationController authController;
	private GUIAuthenticatedUsersController guiAuthUsersController;
	
	
	public GUIMainWindowController(User user) {
		
		initAppView();
		//setActionListeners();
		setMouseListeners();
	
	}
	
	@Override
	public void initAppView() {
		mainWindowView = new GUIMainWindowView();

	}
	
	/*
	 * public void closeApplication() { closeApplication = new
	 * GUICustomCloseApplication();
	 * 
	 * baseWindowView.getContentPane().getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW
	 * ).put(KeyStroke.getKeyStroke("shift ctrl pressed E"),"Exit");
	 * baseWindowView.getContentPane().getActionMap().put("Exit", closeApplication);
	 * 
	 * 
	 * 
	 * }
	 */
	 
	
	 
	@Override
	public void setMouseListeners() {
		// TODO Auto-generated method stub
		super.setMouseListeners();
		
		mainWindowView.getBtnLogin().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				authController = new AuthenticationController(mainWindowView, true);
				authController.start();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}


	/**
	 * @return the mainWindowView
	 */
	public GUIMainWindowView getMainWindowView() {
		return mainWindowView;
	}

	public void start() {
		mainWindowView.setVisible(true);
	}

	public void checkUserAuthenticationStatus(User user) {
		if (user == null) {
			mainWindowView = new GUIMainWindowView();
		} else {
			if (user.isAuthenticated()) {
				guiAuthUsersController = new GUIAuthenticatedUsersController(user);
				guiAuthUsersController.start();
		}	
		}
	}
}
