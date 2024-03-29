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

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.pl.transporthub.aaa.baseclasses.AbstractAuthenticationView;

public class GUILoginView extends AbstractAuthenticationView {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7297067770213513981L;
	private JTextField txtUsername;
	private JPasswordField txtPasswordField;
	private boolean firstRun = true;
	private JButton btnForgotPassword;
	private JButton btnSignUp;
	private JButton btnSignIn;
	private JLabel lblNoUserPassProvided;
	private JLabel lblWrongUserPass;
	private JLabel lblUsername;
	
	private JLabel lblPassword;
	String usernameMessageTip = "Enter Username";
	public GUILoginView(Frame parentFrame, boolean modal) {
		super(parentFrame, modal);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initComponents() {
		super.initComponents();
		btnSignUp = new JButton("Not Registered? Sign Up");
		btnSignUp.setBounds(452, 243, 194, 29);
		
		btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBounds(472, 203, 153, 29);
		btnForgotPassword.setActionCommand("Forgot");
		btnForgotPassword.setForeground(Color.BLACK);
		btnForgotPassword.setOpaque(false);
		btnForgotPassword.setContentAreaFilled(false);
		btnForgotPassword.setBorderPainted(false);
		
		lblNoUserPassProvided = new JLabel("You must enter username and password");
		lblNoUserPassProvided.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoUserPassProvided.setForeground(new Color(204, 0, 51));
		lblNoUserPassProvided.setBounds(372, 176, 347, 16);
		lblNoUserPassProvided.setVisible(false);
		
		lblWrongUserPass = new JLabel("Wrong username or password! Try again!");
		lblWrongUserPass.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrongUserPass.setForeground(new Color(204, 0, 51));
		lblWrongUserPass.setBounds(372, 176, 347, 16);
		lblWrongUserPass.setVisible(false);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(374, 48, 359, 26);
		lblUsername.setForeground(Color.BLACK);
		
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setBounds(374, 75, 345, 26);

		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(374, 112, 359, 26);
		lblPassword.setForeground(Color.BLACK);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(374, 139, 345, 26);
		
		btnSignUp.setOpaque(false);
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		
		btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(502, 283, 87, 29);
		
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setContentAreaFilled(false);
		btnSignIn.setBorderPainted(false);
		btnSignIn.setOpaque(false);
	}

	@Override
	public void setUpAuthenticationView() {
		// TODO Auto-generated method stub
		super.setUpAuthenticationView();
		getContentPanel().add(logoBackgroundPanel);
		getContentPanel().add(lblNoUserPassProvided);
		getContentPanel().add(lblWrongUserPass);
		getContentPanel().add(lblUsername);
		getContentPanel().add(lblPassword);
		getContentPanel().add(txtPasswordField);
		getContentPanel().add(btnForgotPassword);
		getContentPanel().add(btnSignUp);
		getContentPanel().add(txtUsername);
		getContentPanel().add(btnSignIn);
	}

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public JPasswordField getTxtPasswordField() {
		return txtPasswordField;
	}

	public void setTxtPasswordField(JPasswordField txtPasswordField) {
		this.txtPasswordField = txtPasswordField;
	}

	public boolean isFirstRun() {
		return firstRun;
	}

	public void setFirstRun(boolean firstRun) {
		this.firstRun = firstRun;
	}

	public JButton getBtnForgotPassword() {
		return btnForgotPassword;
	}

	public void setBtnForgotPassword(JButton btnForgotPassword) {
		this.btnForgotPassword = btnForgotPassword;
	}

	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	public void setBtnSignUp(JButton btnSignUp) {
		this.btnSignUp = btnSignUp;
	}

	public JButton getBtnSignIn() {
		return btnSignIn;
	}

	public void setBtnSignIn(JButton btnSignIn) {
		this.btnSignIn = btnSignIn;
	}

	public JLabel getLblNoUserPassProvided() {
		return lblNoUserPassProvided;
	}

	public void setLblNoUserPassProvided(JLabel lblNoUserPassProvided) {
		this.lblNoUserPassProvided = lblNoUserPassProvided;
	}

	public JLabel getLblUsername() {
		return lblUsername;
	}

	public void setLblUsername(JLabel lblUsername) {
		this.lblUsername = lblUsername;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public String getUsernameMessageTip() {
		return usernameMessageTip;
	}

	public void setUsernameMessageTip(String usernameMessageTip) {
		this.usernameMessageTip = usernameMessageTip;
	}

	public JLabel getLblWrongUserPass() {
		return lblWrongUserPass;
	}

	public void setLblWrongUserPass(JLabel lblWrongUserPass) {
		this.lblWrongUserPass = lblWrongUserPass;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
