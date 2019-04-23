package com.pl.transporthub.gui;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class TransportHubGUISignInView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6871434862699855261L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TransportHubGUISignInView dialog = new TransportHubGUISignInView();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TransportHubGUISignInView() {
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 729, 420);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(0, 191, 255));
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
//			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
//			flowLayout.setAlignment(FlowLayout.LEFT);
			panel.setBounds(0, 0, 351, 398);
			panel.setBackground(Color.LIGHT_GRAY);
			JLabel logo = new JLabel("");
			logo.setIcon(new ImageIcon(TransportHubGUISignInView.class.getResource("/images/TransportHubLogo351x351_Transparent.png")));
			panel.add(logo);
			contentPanel.add(panel);
		}
		
		{
			
			
			JButton btnSignUp = new JButton("Sign Up");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSignUp.setForeground(Color.GRAY);
				}
			});
			btnSignUp.setForeground(Color.WHITE);
			btnSignUp.setBounds(477, 324, 119, 29);
			btnSignUp.setContentAreaFilled(false);
			btnSignUp.setBorderPainted(false);
			btnSignUp.setOpaque(false);
			contentPanel.add(btnSignUp);
			
			txtUsername = new JTextField();
			txtUsername.setForeground(Color.LIGHT_GRAY);
			txtUsername.setText("For guest access type anonymous");
			txtUsername.setBounds(397, 106, 277, 35);
			contentPanel.add(txtUsername);
			txtUsername.setColumns(10);
			txtUsername.setBackground(Color.WHITE);
			
			JLabel lblUsername = new JLabel("Username");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setBounds(397, 89, 84, 16);
			contentPanel.add(lblUsername);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setBounds(397, 170, 84, 16);
			contentPanel.add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(397, 187, 277, 35);
			contentPanel.add(passwordField);
			
			JButton btnForgotPassword = new JButton("Forgot Password?");
			btnForgotPassword.setActionCommand("Forgot");
			btnForgotPassword.setForeground(Color.WHITE);
			btnForgotPassword.setOpaque(false);
			btnForgotPassword.setContentAreaFilled(false);
			btnForgotPassword.setBorderPainted(false);
			
			
			
			btnForgotPassword.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent forgotButtonClicked) {
					
					if (btnForgotPassword.getActionCommand().equals(forgotButtonClicked.getActionCommand())) {
						
						btnForgotPassword.setForeground(Color.GRAY);

					}
					
				}
			});
			
			
			btnForgotPassword.setBounds(443, 251, 184, 16);
			contentPanel.add(btnForgotPassword);
			
			JButton btnSignIn = new JButton("Not Registered? Sign in");
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSignIn.setForeground(Color.GRAY);
				}
			});
			btnSignIn.setOpaque(false);
			btnSignIn.setForeground(Color.WHITE);
			btnSignIn.setContentAreaFilled(false);
			btnSignIn.setBorderPainted(false);
			btnSignIn.setBounds(443, 279, 192, 16);
			contentPanel.add(btnSignIn);
		
		}

	}

}
