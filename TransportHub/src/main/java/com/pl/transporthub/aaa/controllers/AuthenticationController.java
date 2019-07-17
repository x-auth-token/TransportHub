/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.pl.transporthub.aaa.controllers;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import com.pl.transporthub.aaa.Roles.Role;
import com.pl.transporthub.aaa.baseclasses.PasswordHasher;
import com.pl.transporthub.aaa.views.GUILoginView;
import com.pl.transporthub.aaa.views.GUIResetPasswordView;
import com.pl.transporthub.aaa.views.GUISelfServiceRegisterNewPassangerView;
import com.pl.transporthub.transporthub.controllers.GUIMainWindowController;
import com.pl.transporthub.user.Passenger;



public class AuthenticationController {

	private GUILoginView loginView;
	private GUIResetPasswordView resetPassView;
	private GUISelfServiceRegisterNewPassangerView selfRegisterView;
	
	private GUIMainWindowController mainWindowController;
	private Frame parentFrame;


	public AuthenticationController(final Frame parentFrame, boolean modal) {
		loginView = new GUILoginView(parentFrame, modal);
		resetPassView = new GUIResetPasswordView(parentFrame, modal, false);
		selfRegisterView = new GUISelfServiceRegisterNewPassangerView(parentFrame, modal);
		this.parentFrame = parentFrame;
		setActionListeners();
		setFocusListeners();
		setMouseListeners();
	}


	private void setActionListeners() {
		loginView.getBtnSignUp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.exit();
				selfRegisterView.showAuthView();
			}
		});

		loginView.getBtnForgotPassword().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent forgotButtonClicked) {

				loginView.exit();
				resetPassView.showAuthView();

				
			}
		});

		loginView.getBtnSignIn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String username = loginView.getTxtUsername().getText();
				String hashedPassword = "";

				if (loginView.getTxtPasswordField().getPassword().length != 0) {
					try {
						hashedPassword = PasswordHasher.generateHashedPassword(loginView.getTxtPasswordField().getPassword());
					} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (username.isEmpty() || hashedPassword.isEmpty() || username.equals(loginView.getUsernameMessageTip())) {

					if (!loginView.getLblNoUserPassProvided().isVisible())
						loginView.getLblNoUserPassProvided().setVisible(true);

				} else {
					
					LocalDate date = LocalDate.of(2019, 12, 31);
					
					
					final char[] pass = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
					Passenger passenger = new Passenger("user", pass, date, false);
					passenger.setRole(Role.PASSENGER);
					passenger.setAuthenticated(true);
					loginView.exit();
					mainWindowController = new GUIMainWindowController();
					mainWindowController.checkUserAuthenticationStatus(passenger);
					//parentFrame.setVisible(false);
					//parentFrame.dispose();
				
					
				}

			}
		});
		
		resetPassView.getBtnChangePassword().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetPassView.exit();
				
			}
		});
		
		resetPassView.getBtnCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resetPassView.exit();
				loginView.showAuthView();
				
			}
		});
		
		selfRegisterView.getBtnRegister().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selfRegisterView.exit();
				
			}
		});
		selfRegisterView.getBtnCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selfRegisterView.exit();
				loginView.showAuthView();
			}
		});

	}

	public void setFocusListeners() {
		loginView.getTxtUsername().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (loginView.getTxtUsername().getText().equals("")) {
					loginView.getTxtUsername().setText(loginView.getUsernameMessageTip());
					loginView.getTxtUsername().setForeground(Color.LIGHT_GRAY);
					loginView.getTxtUsername().revalidate();
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (loginView.isFirstRun()) {
					loginView.getTxtUsername().setText(loginView.getUsernameMessageTip());
					loginView.getTxtUsername().setForeground(Color.LIGHT_GRAY);
					loginView.setFirstRun(false);
					loginView.getTxtUsername().transferFocus();

				} else {
					if (loginView.getTxtUsername().getText().equals(loginView.getUsernameMessageTip())) {
						loginView.getTxtUsername().setText("");
						loginView.getTxtUsername().setForeground(Color.BLACK);
						loginView.getTxtUsername().revalidate();
					}
				}

			}
		});
	}

	public void setMouseListeners() {
		loginView.getLblCloseWindow().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				loginView.dispose();

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

		resetPassView.getLblCloseWindow().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				resetPassView.exit();

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



	public boolean validateUsername(String username) {
		return false;
	}

	public boolean validatePassword(String password) {
		return false;
	}


	public String getPasswordFromUserDatabase(String username) {
		return null;
	}

	public void start() {
		loginView.showAuthView();
	}

}
