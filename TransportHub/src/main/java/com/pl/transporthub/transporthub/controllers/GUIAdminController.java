package com.pl.transporthub.transporthub.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.pl.transporthub.transporthub.baseclasses.GUIBaseApplicationView;
import com.pl.transporthub.transporthub.baseclasses.GUICustomCloseApplication;
import com.pl.transporthub.transporthub.views.GUIAdminView;
import com.pl.transporthub.user.User;

public class GUIAdminController {

	private GUIAdminView adminView;
	private User adminUser;
	private GUICustomCloseApplication closeApplication;

	public GUIAdminController(User user) {
		adminUser = user;
		initAppView();
		setActionListeners();
		setMouseListeners();
		
	}

	public void initAppView() {
		adminView = new GUIAdminView();
	}

	public void setActionListeners() {
		
		  closeApplication = new GUICustomCloseApplication();
		  
		  adminView.getContentPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW
		  ).put(KeyStroke.getKeyStroke("shift ctrl pressed E"),"Exit");
		  adminView.getContentPane().getActionMap().put("Exit", closeApplication);
		  
		  
		  adminView.getBtnManageUsers().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					;
				}
			});
		  
		  adminView.getBtnLogs().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					;
				}
			});
		  
		  adminView.getBtnCloseProgram().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					adminUser.setAuthenticated(false);
					adminView.hideAppWindow();
					System.exit(0);
				}
			});
		  
		 

	}

	public void setMouseListeners() {
		adminView.getBtnLogout().addMouseListener(new MouseListener() {

			private GUIMainWindowController mainWindowController;

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				adminUser.setAuthenticated(false);
				adminView.hideAppWindow();
				adminView.closeAppWindow();
				mainWindowController = new GUIMainWindowController();
				mainWindowController.start();

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

	public void start() {
		adminView.showAppWindow();
	}

}
