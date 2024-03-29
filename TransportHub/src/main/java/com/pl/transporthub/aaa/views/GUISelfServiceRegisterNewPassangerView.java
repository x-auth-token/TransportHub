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
package com.pl.transporthub.aaa.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.pl.transporthub.aaa.baseclasses.AbstractAuthenticationView;

public class GUISelfServiceRegisterNewPassangerView extends AbstractAuthenticationView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5670381028528691390L;
	private JTextField txtUsername;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPassportID;
	private JTextField txtEmailAddress;
	private JTextField txtAddress;
	private JTextField txtMobileNumber;
	private JPasswordField txtPasswordField;
	private JPasswordField txtPasswordMatchField;
	
	private JLabel lblUsername;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblPassportID;
	private JLabel lblEmailAddress;
	private JLabel lblAddress;
	private JLabel lblMobileNumber;
	private JLabel lblPassword;
	private JLabel lblPasswordMatch;
	private JLabel lblErrorNotification;
	private JLabel lblRegistrationSuccess;
	
	private JButton btnRegister;
	private JButton btnCancel;
	private JButton btnOK;
	
	public GUISelfServiceRegisterNewPassangerView(Frame parent, boolean modal) {
		super(parent, modal);
		
	}
	
	@Override
	public void initDialog(Frame parent, boolean modal) {
		
		super.initDialog(parent, modal);
		setBounds(100, 100, 729, 700);
		setLocationRelativeTo(parent);
		
	}
	
	@Override
	public void initComponents() {
	
		super.initComponents();
		getContentPanel().setBounds(0, 0, 729, 700);
		
		logoBackgroundPanel = new JPanel();
		logoBackgroundPanel.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(128, 128, 128)));
		logoBackgroundPanel.setBounds(0, 0, 364, 700);
		logoBackgroundPanel.setBackground(new Color(0, 59, 77));
		logoBackgroundPanel.setLayout(new BorderLayout());
		
		logo = new JLabel("");
		logo.setBackground(new Color(102, 0, 204));
		logo.setIcon(new ImageIcon(AbstractAuthenticationView.class.getResource("/images/TransportHubLogoBWBig.png")));
	
		/* Setting Labels and Fields for the following:
		 * Username
		 * First Name
		 * Last Name
		 * Passport ID
		 * Email Address
		 * Address
		 * Mobile Phone Number
		 * Password
		 */
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(374, 18, 359, 26);
		lblUsername.setForeground(Color.BLACK);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setBounds(374, 45, 345, 26);
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(374, 72, 359, 26);
		lblFirstName.setForeground(Color.BLACK);
		
		txtFirstName = new JTextField();
		txtFirstName.setForeground(Color.BLACK);
		txtFirstName.setBounds(374, 99, 345, 26);
		txtFirstName.setColumns(10);
		txtFirstName.setBackground(Color.WHITE);
		
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(374, 126, 359, 26);
		lblLastName.setForeground(Color.BLACK);
		
		txtLastName = new JTextField();
		txtLastName.setForeground(Color.BLACK);
		txtLastName.setBounds(374, 153, 345, 26);
		txtLastName.setColumns(10);
		txtLastName.setBackground(Color.WHITE);
		
		lblPassportID = new JLabel("ID");
		lblPassportID.setBounds(374, 180, 359, 26);
		lblPassportID.setForeground(Color.BLACK);
	
		txtPassportID = new JTextField();
		txtPassportID.setForeground(Color.BLACK);
		txtPassportID.setBounds(374, 207, 345, 26);
		txtPassportID.setColumns(10);
		txtPassportID.setBackground(Color.WHITE);
		
		lblEmailAddress = new JLabel("Email");
		lblEmailAddress.setBounds(374, 234, 359, 26);
		lblEmailAddress.setForeground(Color.BLACK);
	
		txtEmailAddress = new JTextField();
		txtEmailAddress.setForeground(Color.BLACK);
		txtEmailAddress.setBounds(374, 261, 345, 26);
		txtEmailAddress.setColumns(10);
		txtEmailAddress.setBackground(Color.WHITE);
		
		lblAddress = new JLabel("Address (Apt,Building,Street,City,Zip,Country)");
		lblAddress.setBounds(374, 288, 359, 26);
		lblAddress.setForeground(Color.BLACK);
	
		txtAddress = new JTextField();
		txtAddress.setForeground(Color.BLACK);
		txtAddress.setBounds(374, 315, 345, 26);
		txtAddress.setColumns(10);
		txtAddress.setBackground(Color.WHITE);
		
		lblMobileNumber = new JLabel("Mobile");
		lblMobileNumber.setBounds(374, 342, 359, 26);
		lblMobileNumber.setForeground(Color.BLACK);
	
		txtMobileNumber = new JTextField();
		txtMobileNumber.setForeground(Color.BLACK);
		txtMobileNumber.setBounds(374, 369, 345, 26);
		txtMobileNumber.setColumns(10);
		txtMobileNumber.setBackground(Color.WHITE);
		
		lblPassword = new JLabel("New Password");
		lblPassword.setBounds(374, 396, 359, 26);
		lblPassword.setForeground(Color.BLACK);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(374, 423, 345, 26);
		
		
		lblPasswordMatch = new JLabel("Enter Password Again");
		lblPasswordMatch.setBounds(374, 450, 359, 26);
		lblPasswordMatch.setForeground(Color.BLACK);

		txtPasswordMatchField = new JPasswordField();
		txtPasswordMatchField.setBounds(374, 477, 345, 26);
		
		lblErrorNotification = new JLabel();
		lblErrorNotification.setForeground(Color.RED);
		lblErrorNotification.setVisible(false);
		
		lblRegistrationSuccess = new JLabel("Registration Successfull! Please Login!");
		lblRegistrationSuccess.setBounds(420, 207, 345, 26);
		lblRegistrationSuccess.setForeground(new Color(0, 100, 0));
		lblRegistrationSuccess.setVisible(false);

		btnRegister = new JButton("Register");
		btnRegister.setBounds(472, 570, 153, 29);
		btnRegister.setForeground(Color.BLACK);
		btnRegister.setContentAreaFilled(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setOpaque(false);
		btnRegister.setAlignmentX(CENTER_ALIGNMENT);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(472, 597, 153, 29);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setOpaque(false);
		btnCancel.setAlignmentX(CENTER_ALIGNMENT);
		
		btnOK = new JButton("OK");
		btnOK.setBounds(472, 597, 153, 29);
		btnOK.setForeground(Color.BLACK);
		btnOK.setContentAreaFilled(false);
		btnOK.setBorderPainted(false);
		btnOK.setOpaque(false);
		btnOK.setAlignmentX(CENTER_ALIGNMENT);
		btnOK.setVisible(false);
		
	}
	
	@Override
	public void setUpAuthenticationView() {
		// TODO Auto-generated method stub
		super.setUpAuthenticationView();
		logoBackgroundPanel.add(logo, BorderLayout.CENTER);
		
		getContentPanel().add(lblUsername);
		getContentPanel().add(txtUsername);
		getContentPanel().add(lblFirstName);
		getContentPanel().add(txtFirstName);
		getContentPanel().add(lblLastName);
		getContentPanel().add(txtLastName);
		getContentPanel().add(lblPassportID);
		getContentPanel().add(txtPassportID);
		getContentPanel().add(lblEmailAddress);
		getContentPanel().add(txtEmailAddress);
		getContentPanel().add(lblAddress);
		getContentPanel().add(txtAddress);
		getContentPanel().add(lblMobileNumber);
		getContentPanel().add(txtMobileNumber);
		getContentPanel().add(lblPassword);
		getContentPanel().add(txtPasswordField);
		getContentPanel().add(lblPasswordMatch);
		getContentPanel().add(txtPasswordMatchField);
		getContentPanel().add(lblErrorNotification);
		getContentPanel().add(lblRegistrationSuccess);
		getContentPanel().add(btnRegister);
		getContentPanel().add(btnCancel);
		getContentPanel().add(btnOK);
		
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public JTextField getTxtFirstName() {
		return txtFirstName;
	}

	public JTextField getTxtLastName() {
		return txtLastName;
	}

	public JTextField getTxtPassportID() {
		return txtPassportID;
	}

	public JTextField getTxtEmailAddress() {
		return txtEmailAddress;
	}

	public JTextField getTxtAddress() {
		return txtAddress;
	}

	public JTextField getTxtMobileNumber() {
		return txtMobileNumber;
	}

	public JPasswordField getTxtPasswordField() {
		return txtPasswordField;
	}

	public JPasswordField getTxtPasswordMatchField() {
		return txtPasswordMatchField;
	}

	public JLabel getLblUsername() {
		return lblUsername;
	}

	public JLabel getLblFirstName() {
		return lblFirstName;
	}

	public JLabel getLblLastName() {
		return lblLastName;
	}

	public JLabel getLblPassportID() {
		return lblPassportID;
	}

	public JLabel getLblEmailAddress() {
		return lblEmailAddress;
	}

	public JLabel getLblAddress() {
		return lblAddress;
	}

	public JLabel getLblMobileNumber() {
		return lblMobileNumber;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public JLabel getLblPasswordMatch() {
		return lblPasswordMatch;
	}

	public JButton getBtnRegister() {
		return btnRegister;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JLabel getLblErrorNotification() {
		return lblErrorNotification;
	}

	public JLabel getLblRegistrationSuccess() {
		return lblRegistrationSuccess;
	}

	public JButton getBtnOK() {
		return btnOK;
	}
	
	

}
