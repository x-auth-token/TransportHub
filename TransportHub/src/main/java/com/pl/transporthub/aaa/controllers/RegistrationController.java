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

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import com.pl.transporthub.aaa.baseclasses.PasswordHasher;
import com.pl.transporthub.aaa.views.GUISelfServiceRegisterNewPassangerView;
import com.pl.transporthub.user.User;
import com.pl.transporthub.user.UserController;
import com.pl.transporthub.user.UserFactory;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import javafx.scene.Parent;

public class RegistrationController {
	private GUISelfServiceRegisterNewPassangerView selfRegisterView;
	private AuthenticationController authController;
	private UserController userController;
	private User user;
	
	public RegistrationController(Frame parentFrame, boolean modal) {
		
		selfRegisterView = new GUISelfServiceRegisterNewPassangerView(parentFrame, modal);
		userController = new UserController();
		//authController = new AuthenticationController(parentFrame, modal);
		setActionListeners();
		setMouseListeners();
		
		
	}
	
	public void start() {
		selfRegisterView.showAuthView();
	}

	public GUISelfServiceRegisterNewPassangerView getSelfRegisterView() {
		return selfRegisterView;
	}
	
	public void setKeyListeners() {
	
	}
	
	public void setActionListeners() {
		selfRegisterView.getBtnRegister().addActionListener(new ActionListener() {
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if ( selfRegisterView.getTxtPasswordField().getPassword().length == 0 ||
							selfRegisterView.getTxtPasswordMatchField().getPassword().length == 0) {
						selfRegisterView.getLblErrorNotification().setText("Empty passwords are not allowed!");
						selfRegisterView.getLblErrorNotification().setBounds(445, 530, 359, 26);
						selfRegisterView.getLblErrorNotification().setVisible(true);
						
					} else if (!isPasswordMatch()) {
						selfRegisterView.getLblErrorNotification().setText("Passwords doesn't match!");
						selfRegisterView.getLblErrorNotification().setBounds(474, 530, 359, 26);
						selfRegisterView.getLblErrorNotification().setVisible(true);
					} else {
						registerUser();
						hideAllElements();
						registrationSuccess();
						
						
					}
				
				} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		selfRegisterView.getBtnCancel().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selfRegisterView.exit();
				
				
			}
		});
		
		selfRegisterView.getBtnOK().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				selfRegisterView.exit();
				
				
			}
		});
	}
	
	public void setMouseListeners() {
		selfRegisterView.getLblCloseWindow().addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				selfRegisterView.dispose();

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
	
	private void registerUser()  throws NoSuchAlgorithmException, InvalidKeySpecException{
		String username = selfRegisterView.getTxtUsername().getText();
		String hashedPassword = PasswordHasher.generateHashedPassword(selfRegisterView.getTxtPasswordField().getPassword());
		String email = selfRegisterView.getTxtEmailAddress().getText();
		String mobileNumber = selfRegisterView.getTxtMobileNumber().getText();
		String firstName = selfRegisterView.getTxtFirstName().getText();
		String lastName = selfRegisterView.getTxtLastName().getText();
		String passportID = selfRegisterView.getTxtPassportID().getText();
		String address = selfRegisterView.getTxtAddress().getText();
		
		
		
		user = UserFactory.getUser("PASSENGER", username, hashedPassword);
		
		user.setEmail(email);
		user.setMobileNumber(mobileNumber);
		user.setAddress(address);
		user.setPassportID(passportID);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		userController.start();
		userController.addUser(user);
		
	}
	
	private boolean isPasswordMatch() {
		
		char[] password1 = selfRegisterView.getTxtPasswordField().getPassword();
		char[] password2 = selfRegisterView.getTxtPasswordMatchField().getPassword();
		if (Arrays.equals(password1, password2)) {
			return true;
		}
		return false;
	}
	
	private void hideAllElements() {
		
		// Hide Labels
		selfRegisterView.getLblUsername().setVisible(false);
		selfRegisterView.getLblFirstName().setVisible(false);
		selfRegisterView.getLblLastName().setVisible(false);
		selfRegisterView.getLblPassportID().setVisible(false);
		selfRegisterView.getLblEmailAddress().setVisible(false);
		selfRegisterView.getLblAddress().setVisible(false);
		selfRegisterView.getLblMobileNumber().setVisible(false);
		selfRegisterView.getLblPassword().setVisible(false);
		selfRegisterView.getLblPasswordMatch().setVisible(false);
		
		// Hide Text Fields
		selfRegisterView.getTxtUsername().setVisible(false);
		selfRegisterView.getTxtFirstName().setVisible(false);
		selfRegisterView.getTxtLastName().setVisible(false);
		selfRegisterView.getTxtPassportID().setVisible(false);
		selfRegisterView.getTxtEmailAddress().setVisible(false);
		selfRegisterView.getTxtAddress().setVisible(false);
		selfRegisterView.getTxtMobileNumber().setVisible(false);
		selfRegisterView.getTxtPasswordField().setVisible(false);
		selfRegisterView.getTxtPasswordMatchField().setVisible(false);
		
		// Hide Buttons
		
		selfRegisterView.getBtnRegister().setVisible(false);
		selfRegisterView.getBtnCancel().setVisible(false);
	}
	
	private void registrationSuccess() {
		selfRegisterView.getLblRegistrationSuccess().setVisible(true);
		selfRegisterView.getBtnOK().setVisible(true);
	}
}
