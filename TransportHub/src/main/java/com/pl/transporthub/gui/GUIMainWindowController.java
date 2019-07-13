package com.pl.transporthub.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.pl.transporthub.aaa.AuthenticationController;

public class GUIMainWindowController {
	
	private GUIMainWindowView mainWindowView;
	private GUICustomCloseApplication closeApplication;
	
	public GUIMainWindowController() {
		mainWindowView = new GUIMainWindowView();
		//setActionListeners();
		setMouseListeners();
	}
	
	public void setActionListeners() {
		closeApplication = new GUICustomCloseApplication();
		mainWindowView.getContentPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift ctrl pressed E"),
				"Exit");
		mainWindowView.getContentPane().getActionMap().put("Exit", closeApplication);
	}
	
	public void setMouseListeners() {
		mainWindowView.getRbLogin().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				/*
				 * AuthenticationView signIn = new AuthenticationView(null, true);
				 * signIn.setVisible(true);
				 */
				
				AuthenticationController authController = new AuthenticationController(null, true);
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
	
	public void start() {
		mainWindowView.setVisible(true);
	}
}
