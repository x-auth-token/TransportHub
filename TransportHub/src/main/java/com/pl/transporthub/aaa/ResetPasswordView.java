package com.pl.transporthub.aaa;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ResetPasswordView extends AuthenticationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7964804653354506304L;
	private JTextField txtUsername;
	private JTextField txtSecretQuestion;
	private JPasswordField txtPasswordField;
	private JPasswordField txtNewPasswordField;
	private JPasswordField txtNewPassPasswordMatchField;
	private JLabel lblUsername;
	private JLabel lblSecretQuestion;
	private JLabel lblOldPassword;
	private JLabel lblNewPassword;
	private JLabel lblNewPasswordMatch;
	
	
	
	public ResetPasswordView(Frame parent, boolean modal, boolean change) {
		super(parent, modal);
		
		if (change) {
			initComponentsChangePassword();
		} else {
			initComponentsForgotPassword();
		}
	}



	
	public void initComponentsForgotPassword() {
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(374, 48, 359, 26);
		lblUsername.setForeground(Color.BLACK);
		
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setBounds(374, 75, 345, 26);
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		
		lblSecretQuestion = new JLabel("Secret Question");
		lblSecretQuestion.setBounds(374, 112, 359, 26);
		lblSecretQuestion.setForeground(Color.BLACK);
	
		txtSecretQuestion = new JTextField();
		txtSecretQuestion.setForeground(Color.LIGHT_GRAY);
		txtSecretQuestion.setBounds(374, 139, 345, 26);
		txtSecretQuestion.setColumns(10);
		txtSecretQuestion.setBackground(Color.WHITE);

		

		lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(374, 176, 359, 26);
		lblNewPassword.setForeground(Color.BLACK);
		
		lblNewPasswordMatch = new JLabel("Match Password");
		lblNewPasswordMatch.setBounds(374, 203, 359, 26);
		lblNewPasswordMatch.setForeground(Color.BLACK);
		
		txtNewPasswordField = new JPasswordField();
		txtNewPasswordField.setBounds(374, 240, 345, 26);
		
		txtNewPassPasswordMatchField = new JPasswordField();
		txtNewPassPasswordMatchField.setBounds(374, 267, 345, 26);
	}


	public void initComponentsChangePassword() {
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(374, 48, 359, 26);
		lblUsername.setForeground(Color.BLACK);
		
		
		txtUsername = new JTextField();
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setBounds(374, 75, 345, 26);
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		
		lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(374, 112, 359, 26);
		lblOldPassword.setForeground(Color.BLACK);
	
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(374, 139, 345, 26);

		lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(374, 176, 359, 26);
		lblNewPassword.setForeground(Color.BLACK);
		
		lblNewPasswordMatch = new JLabel("Enter Password Again");
		lblNewPasswordMatch.setBounds(374, 203, 359, 26);
		lblNewPasswordMatch.setForeground(Color.BLACK);
		
		txtNewPasswordField = new JPasswordField();
		txtNewPasswordField.setBounds(374, 240, 345, 26);
		
		txtNewPassPasswordMatchField = new JPasswordField();
		txtNewPassPasswordMatchField.setBounds(374, 267, 345, 26);
	}
	
}
