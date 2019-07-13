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

//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import com.sun.glass.ui.Window;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class AuthenticationView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6871434862699855261L;
	private JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPasswordField;
	private boolean firstRun = true;
	private JButton btnForgotPassword;
	private JButton btnSignUp;
	private JButton btnSignIn;
	private JLabel lblNoUserPassProvided;
	private JLabel lblUsername;
	private JPanel logoBackgroundPanel;
	private JLabel lblPassword;
	private JLabel lblCloseWindow;
	private JLabel logo;
	String usernameMessageTip = "Enter Username";

	/**
	 * Create the dialog.
	 */
	public AuthenticationView(final Frame parent, boolean modal) {
		
		initDialog(parent, modal);
		initComponents();
		setUpAuthenticationView();
		
	}
	
	
	public void initDialog(final Frame parent, boolean modal) {
		setUndecorated(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(true);
		setBackground(Color.WHITE);
		setBounds(100, 100, 729, 327);
		setLocationRelativeTo(parent);
		setModal(modal);
		
	}
	
	public void initComponents() {
		
		contentPanel.setBounds(0, 0, 729, 327);
		contentPanel.setBackground(new Color(222, 224, 224));
		contentPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
		
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
		
		lblCloseWindow = new JLabel("");
		lblCloseWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseWindow.setIcon(new ImageIcon(
				AuthenticationView.class.getResource("/images/TansportHubCloseWindowButtomImageSmall.png")));
		lblCloseWindow.setBounds(705, 6, 14, 16);
		
		logoBackgroundPanel = new JPanel();
		logoBackgroundPanel.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(128, 128, 128)));
		logoBackgroundPanel.setBounds(0, 0, 364, 327);
		logoBackgroundPanel.setBackground(new Color(0, 59, 77));
		
		logo = new JLabel("");
		logo.setBackground(new Color(102, 0, 204));
		logo.setIcon(new ImageIcon(AuthenticationView.class.getResource("/images/TransportHubLogoBWBig.png")));
		
		contentPanel.setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		
	}
	
	public void setUpAuthenticationView() {
		
		logoBackgroundPanel.add(logo);
		contentPanel.add(logoBackgroundPanel);
		contentPanel.add(lblNoUserPassProvided);
		contentPanel.add(lblUsername);
		contentPanel.add(lblPassword);
		contentPanel.add(txtPasswordField);
		contentPanel.add(btnForgotPassword);
		contentPanel.add(btnSignUp);
		contentPanel.add(txtUsername);
		contentPanel.add(btnSignIn);
		contentPanel.add(lblCloseWindow);
		
		
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

	public JPanel getContentPanel() {
		return contentPanel;
		
	}
	
	public void setContentPanel(JPanel panel) {
		this.contentPanel = panel;
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


	public JPanel getLogoBackgroundPanel() {
		return logoBackgroundPanel;
	}


	public void setLogoBackgroundPanel(JPanel logoBackgroundPanel) {
		this.logoBackgroundPanel = logoBackgroundPanel;
	}


	public JLabel getLblPassword() {
		return lblPassword;
	}


	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}


	public JLabel getLblCloseWindow() {
		return lblCloseWindow;
	}


	public void setLblCloseWindow(JLabel lblCloseWindow) {
		this.lblCloseWindow = lblCloseWindow;
	}


	public JLabel getLogo() {
		return logo;
	}


	public void setLogo(JLabel logo) {
		this.logo = logo;
	}


	public String getUsernameMessageTip() {
		return usernameMessageTip;
	}


	public void setUsernameMessageTip(String usernameMessageTip) {
		this.usernameMessageTip = usernameMessageTip;
	}


	public void showAuthView() {
		setVisible(true);
	}
	
	public void exit() {
		dispose();
	}
	
}
