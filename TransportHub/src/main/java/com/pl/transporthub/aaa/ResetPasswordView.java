package com.pl.transporthub.aaa;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
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
	private JPasswordField txtOldPasswordField;
	private JPasswordField txtNewPasswordField;
	private JPasswordField txtNewPassPasswordMatchField;
	private JLabel lblUsername;
	private JLabel lblSecretQuestion;
	private JLabel lblOldPassword;
	private JLabel lblNewPassword;
	private JLabel lblNewPasswordMatch;
	private boolean changePassword;
	private JButton btnChangePassword;
	private JButton btnCancel;
	
	
	
	public ResetPasswordView(Frame parent, boolean modal, boolean change) {
		super(parent, modal);
		setChangePassword(change);
		
	}

	
	public boolean isChangePassword() {
		return changePassword;
	}


	public void setChangePassword(boolean changePassword) {
		this.changePassword = changePassword;
	}

	@Override
	public void initComponents() {

		super.initComponents();

		lblUsername = new JLabel("Username");
		lblUsername.setBounds(374, 18, 359, 26);
		lblUsername.setForeground(Color.BLACK);


		txtUsername = new JTextField();
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setBounds(374, 45, 345, 26);
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		
		btnChangePassword = new JButton();
		btnChangePassword.setBounds(472, 253, 153, 29);
		btnChangePassword.setForeground(Color.BLACK);
		btnChangePassword.setContentAreaFilled(false);
		btnChangePassword.setBorderPainted(false);
		btnChangePassword.setOpaque(false);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(472, 283, 153, 29);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setOpaque(false);
		
		if (isChangePassword()) {
			lblOldPassword = new JLabel("Old Password");
			lblOldPassword.setBounds(374, 72, 359, 26);
			lblOldPassword.setForeground(Color.BLACK);
			
			txtOldPasswordField = new JPasswordField();
			txtOldPasswordField.setBounds(374, 99, 345, 26);
			
			btnChangePassword.setText("Change Password");
		} else {
			lblSecretQuestion = new JLabel("Secret Question");
			lblSecretQuestion.setBounds(374, 72, 359, 26);
			lblSecretQuestion.setForeground(Color.BLACK);

			txtSecretQuestion = new JTextField();
			txtSecretQuestion.setForeground(Color.LIGHT_GRAY);
			txtSecretQuestion.setBounds(374, 99, 345, 26);
			txtSecretQuestion.setColumns(10);
			txtSecretQuestion.setBackground(Color.WHITE);
			
			btnChangePassword.setText("Reset Password");
		}
			lblNewPassword = new JLabel("New Password");
			lblNewPassword.setBounds(374, 136, 359, 26);
			lblNewPassword.setForeground(Color.BLACK);

			lblNewPasswordMatch = new JLabel("Enter Password Again");
			lblNewPasswordMatch.setBounds(374, 190, 359, 26);
			lblNewPasswordMatch.setForeground(Color.BLACK);

			txtNewPasswordField = new JPasswordField();
			txtNewPasswordField.setBounds(374, 163, 345, 26);

			txtNewPassPasswordMatchField = new JPasswordField();
			txtNewPassPasswordMatchField.setBounds(374, 217, 345, 26);
		
	}
	
	@Override
	public void setUpAuthenticationView() {
		
		super.setUpAuthenticationView();

		getContentPanel().add(lblUsername);
		getContentPanel().add(txtUsername);
		getContentPanel().add(btnChangePassword);
		getContentPanel().add(btnCancel);
		
		if (isChangePassword()) {
			getContentPanel().add(lblOldPassword);
			getContentPanel().add(txtOldPasswordField);
		} else {	
			getContentPanel().add(lblSecretQuestion);
			getContentPanel().add(txtSecretQuestion);
		}
		getContentPanel().add(lblNewPassword);
		getContentPanel().add(lblNewPasswordMatch);
		getContentPanel().add(txtNewPasswordField);
		getContentPanel().add(txtNewPassPasswordMatchField);

	}

	
	public JTextField getTxtUsername() {
		return txtUsername;
	}


	public JTextField getTxtSecretQuestion() {
		return txtSecretQuestion;
	}


	public JPasswordField getTxtPasswordField() {
		return txtOldPasswordField;
	}


	public JPasswordField getTxtNewPasswordField() {
		return txtNewPasswordField;
	}


	public JPasswordField getTxtNewPassPasswordMatchField() {
		return txtNewPassPasswordMatchField;
	}


	public JLabel getLblUsername() {
		return lblUsername;
	}


	public JLabel getLblSecretQuestion() {
		return lblSecretQuestion;
	}


	public JLabel getLblOldPassword() {
		return lblOldPassword;
	}
	
	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public JPasswordField getTxtOldPasswordField() {
		return txtOldPasswordField;
	}


	public JButton getBtnChangePassword() {
		return btnChangePassword;
	}


	public JButton getBtnCancel() {
		return btnCancel;
	}


	public JLabel getLblNewPassword() {
		return lblNewPassword;
	}


	public JLabel getLblNewPasswordMatch() {
		return lblNewPasswordMatch;
	}
	
	
	
	
	
}
