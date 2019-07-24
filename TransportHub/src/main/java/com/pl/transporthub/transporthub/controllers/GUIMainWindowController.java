/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.pl.transporthub.transporthub.controllers;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import com.pl.transporthub.aaa.controllers.AuthenticationController;
import com.pl.transporthub.transport.TransportController;
import com.pl.transporthub.transporthub.baseclasses.GUIAbstractApplicationWindowController;
import com.pl.transporthub.transporthub.baseclasses.GUICustomCloseApplication;
import com.pl.transporthub.transporthub.views.GUIMainWindowView;
import com.pl.transporthub.user.User;
import com.pl.transporthub.user.UserRepository;

public class GUIMainWindowController extends GUIAbstractApplicationWindowController {

	private GUIMainWindowView mainWindowView;

	// private GUICustomCloseApplication closeApplication;

	private AuthenticationController authController;
	private GUIAuthenticatedUsersController guiAuthUsersController;
	private TransportController transportController = new TransportController();

	private UserRepository ur;

	public GUIMainWindowController() {

		initAppView();
		// setActionListeners();
		setMouseListeners();
		transportController.start();
		populateBusTable();
		

	}

	@Override
	public void initAppView() {
		mainWindowView = new GUIMainWindowView();

	}

	public void closeApplication() {
		closeApplication = new GUICustomCloseApplication();
		mainWindowView.getContentPane().getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke("shift ctrl pressed E"), "Exit");
		mainWindowView.getContentPane().getActionMap().put("Exit", closeApplication);

	}

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
				authController = new AuthenticationController(mainWindowView.getAppFrame(), true);
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
		
		mainWindowView.getBtnBus().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				populateBusTable();
				
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
		
		mainWindowView.getBtnStation().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				populateStationTable();
				
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
		mainWindowView.getAppFrame().setVisible(true);
	}

	/*
	 * public void authenticate(User u) { ur = new UserRepository();
	 * 
	 * if (u.getUsername().equals(ur.get(u))) ;
	 * 
	 * }
	 */

	public void checkUserAuthenticationStatus(User user) {
		if (user == null) {
			mainWindowView = new GUIMainWindowView();
		} else {
			if (user.isAuthenticated()) {
				guiAuthUsersController = new GUIAuthenticatedUsersController(user);
				guiAuthUsersController.start();
				mainWindowView.hideAppWindow();

				mainWindowView.closeAppWindow();
			}
		}
	}
	
	public void populateBusTable() {
		try {
			DefaultTableModel tblModel = transportController.generateBusTableModel();
			
			mainWindowView.getTblTransportTable().setModel(tblModel);
			
			mainWindowView.getTblTransportTable().setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void populateStationTable() {
		try {
			DefaultTableModel tblModel = transportController.generateStationTableModel();
			
			mainWindowView.getTblTransportTable().setModel(tblModel);
			mainWindowView.getTblTransportTable().setVisible(true);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
}
