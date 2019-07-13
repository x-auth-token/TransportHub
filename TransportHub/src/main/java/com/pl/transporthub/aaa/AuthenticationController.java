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
package com.pl.transporthub.aaa;

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

import javax.swing.JDialog;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.SwingUtilities;

import com.pl.transporthub.user.User;

public class AuthenticationController {

	private LoginView authView;
	private ResetPasswordView resetPassView;
	private SelfServiceRegisterNewPassangerView selfRegisterView;


	public AuthenticationController(final Frame parent, boolean modal) {
		authView = new LoginView(parent, modal);
		resetPassView = new ResetPasswordView(parent, modal, false);
		selfRegisterView = new SelfServiceRegisterNewPassangerView(parent, modal);
		setActionListeners();
		setFocusListeners();
		setMouseListeners();
	}


	private void setActionListeners() {
		authView.getBtnSignUp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				authView.exit();
				selfRegisterView.showAuthView();
			}
		});

		authView.getBtnForgotPassword().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent forgotButtonClicked) {

				authView.exit();
				resetPassView.showAuthView();

				
			}
		});

		authView.getBtnSignIn().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String username = authView.getTxtUsername().getText();
				String hashedPassword = "";

				if (authView.getTxtPasswordField().getPassword().length != 0) {
					try {
						hashedPassword = PasswordHasher.generateHashedPassword(authView.getTxtPasswordField().getPassword());
					} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (username.isEmpty() || hashedPassword.isEmpty() || username.equals(authView.getUsernameMessageTip())) {

					if (!authView.getLblNoUserPassProvided().isVisible())
						authView.getLblNoUserPassProvided().setVisible(true);

				} else {
					authView.exit();
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
				authView.showAuthView();
				
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
				authView.showAuthView();
			}
		});

	}

	public void setFocusListeners() {
		authView.getTxtUsername().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

				if (authView.getTxtUsername().getText().equals("")) {
					authView.getTxtUsername().setText(authView.getUsernameMessageTip());
					authView.getTxtUsername().setForeground(Color.LIGHT_GRAY);
					authView.getTxtUsername().revalidate();
				}

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (authView.isFirstRun()) {
					authView.getTxtUsername().setText(authView.getUsernameMessageTip());
					authView.getTxtUsername().setForeground(Color.LIGHT_GRAY);
					authView.setFirstRun(false);
					authView.getTxtUsername().transferFocus();

				} else {
					if (authView.getTxtUsername().getText().equals(authView.getUsernameMessageTip())) {
						authView.getTxtUsername().setText("");
						authView.getTxtUsername().setForeground(Color.BLACK);
						authView.getTxtUsername().revalidate();
					}
				}

			}
		});
	}

	public void setMouseListeners() {
		authView.getLblCloseWindow().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				authView.dispose();

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
		authView.showAuthView();
	}

}
