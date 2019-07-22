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
package com.pl.transporthub.aaa.controllers;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;

import javax.naming.AuthenticationException;

import org.apache.commons.codec.DecoderException;

import com.pl.transporthub.aaa.Roles.Role;
import com.pl.transporthub.aaa.baseclasses.PasswordHasher;
import com.pl.transporthub.aaa.views.GUILoginView;
import com.pl.transporthub.aaa.views.GUIResetPasswordView;
import com.pl.transporthub.aaa.views.GUISelfServiceRegisterNewPassangerView;
import com.pl.transporthub.transporthub.controllers.GUIMainWindowController;
import com.pl.transporthub.user.Passenger;
import com.pl.transporthub.user.User;
import com.pl.transporthub.user.UserController;
import com.pl.transporthub.user.UserFactory;
import com.pl.transporthub.user.UserRepository;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;



public class AuthenticationController {

	private GUILoginView loginView;
	private GUIResetPasswordView resetPassView;
	
	private RegistrationController selfRegController;
	private GUIMainWindowController mainWindowController;
	private Frame parentFrame;
	private UserController uc = new UserController();


	public AuthenticationController(final Frame parentFrame, boolean modal) {
		loginView = new GUILoginView(parentFrame, modal);
		resetPassView = new GUIResetPasswordView(parentFrame, modal, false);
		selfRegController = new RegistrationController(parentFrame, modal);
		this.parentFrame = parentFrame;
		uc.start();
		setKeyListeners();
		setActionListeners();
		setFocusListeners();
		setMouseListeners();
	}
	
	private void setKeyListeners() {
		loginView.getTxtPasswordField().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					login();	
					

					}
				}
				
			
		});
		
		loginView.getTxtUsername().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				

					}
				}
				
			
		});
	}

	private void setActionListeners() {
		loginView.getBtnSignUp().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.exit();
				selfRegController.start();
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
				login();
			

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
						
						if (loginView.getLblWrongUserPass().isVisible()) {
							loginView.getLblWrongUserPass().setVisible(false);
						} else if (loginView.getLblNoUserPassProvided().isVisible()) {
							loginView.getLblNoUserPassProvided().setVisible(false);
						}
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

	

	private boolean validateUsername(String username) {
		//if (username.equalsIgnoreCase(ur.get(username)))
		return false;
	}

	private boolean validatePassword(String password) {
		return false;
	}


	public String getPasswordFromUserDatabase(String username) {
		return null;
	}

	private User authenticateUser(String username, char []password ) {
		
		if (uc.getUserRepository().getUserByName(username) != null) {
			UserFactory uf = new UserFactory();
			User user = UserFactory.getUser(uc.getUserRepository().getUserRole(username), username, uc.getUserRepository().getUserPassword(username));
			
			try {
				if (PasswordHasher.validateHashedPassword(password, user.getPassword())) {
					user.setAuthenticated(true);
					return user;
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DecoderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			return null;
	}
	
	private void login() {
		String username = loginView.getTxtUsername().getText();
		
		User user;

		 

		if (username.isEmpty() || loginView.getTxtPasswordField().getPassword().length == 0 || username.equals(loginView.getUsernameMessageTip())) {

			
			  if (!loginView.getLblNoUserPassProvided().isVisible()) {
				  loginView.getLblNoUserPassProvided().setVisible(true);
			  } else {
				  loginView.getLblNoUserPassProvided().setVisible(false);
			  }
			 
			
		} else {
			
			if ((user = authenticateUser(username, loginView.getTxtPasswordField().getPassword())) == null) {
				if (!loginView.getLblWrongUserPass().isVisible()) {
					loginView.getLblWrongUserPass().setVisible(true);
				} else {
					loginView.getLblWrongUserPass().setVisible(true);
				}
			} else {
				loginView.exit();
				mainWindowController = new GUIMainWindowController();
				mainWindowController.checkUserAuthenticationStatus(user);
				parentFrame.setVisible(false);
				parentFrame.dispose();
				
			}

			 				
			
		}

	
	}
	
	public void start() {
		loginView.showAuthView();
	}

}
