package com.pl.transporthub.aaa.controllers;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.pl.transporthub.aaa.baseclasses.PasswordHasher;
import com.pl.transporthub.aaa.views.GUISelfServiceRegisterNewPassangerView;
import com.pl.transporthub.user.User;
import com.pl.transporthub.user.UserController;
import com.pl.transporthub.user.UserFactory;

import javafx.scene.Parent;

public class RegistrationController {
	private GUISelfServiceRegisterNewPassangerView selfRegisterView;
	private AuthenticationController authController;
	private UserController userController;
	private User user;
	
	public RegistrationController(Frame parentFrame, boolean modal) {
		
		selfRegisterView = new GUISelfServiceRegisterNewPassangerView(parentFrame, modal);
		userController = new UserController();
		
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
					if (isPasswordMatch()) {
						registerUser();
					} 
					else {
						// Add lbl For password Doesn't match
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
	}
	
	private void registerUser()  throws NoSuchAlgorithmException, InvalidKeySpecException{
		String username = selfRegisterView.getTxtUsername().toString();
		String hashedPassword = PasswordHasher.generateHashedPassword(selfRegisterView.getTxtPasswordField().getPassword());
		String email = selfRegisterView.getTxtEmailAddress().toString();
		String mobileNumber = selfRegisterView.getTxtMobileNumber().toString();
		String firstName = selfRegisterView.getTxtFirstName().toString();
		String lastName = selfRegisterView.getTxtLastName().toString();
		String passportID = selfRegisterView.getTxtPassportID().toString();
		String address = selfRegisterView.getTxtAddress().toString();
		
		user = UserFactory.getUser("PASSENGER", username, hashedPassword);
		
		user.setEmail(email);
		user.setMobileNumber(mobileNumber);
		user.setAddress(address);
		user.setPassportID(passportID);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		userController.saveUser(user);
	}
	
	private boolean isPasswordMatch() {
		
		char[] password1 = selfRegisterView.getTxtPasswordField().getPassword();
		char[] password2 = selfRegisterView.getTxtPasswordMatchField().getPassword();
		if (password1.equals(password2)) {
			return true;
		}
		return false;
	}
	
}
