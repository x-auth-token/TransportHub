package com.pl.transporthub.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Label;

public class TransportHubGUISignIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransportHubGUISignIn frame = new TransportHubGUISignIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TransportHubGUISignIn() {
		
		try {
	        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} 
		catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
		}
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 420);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 351, 398);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TransportHubGUISignIn.class.getResource("/images/TransportHubLogo351x351_Transparent.png")));
		panel.add(lblNewLabel_1);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBounds(397, 324, 277, 29);
		btnSignUp.setBackground(new Color(241, 57, 83));
		btnSignUp.setBorderPainted(false);
		btnSignUp.setOpaque(true);
		contentPane.add(btnSignUp);
		
		textField = new JTextField();
		textField.setBounds(397, 106, 277, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(397, 89, 84, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(397, 170, 84, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(397, 187, 277, 35);
		contentPane.add(passwordField);
		
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setActionCommand("Forgot");
		btnForgotPassword.setForeground(Color.WHITE);
		btnForgotPassword.setOpaque(false);
		btnForgotPassword.setContentAreaFilled(false);
		btnForgotPassword.setBorderPainted(false);
		
		
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent forgotButtonClicked) {
				
				if (btnForgotPassword.getActionCommand().equals(forgotButtonClicked.getActionCommand())) {
					
					btnForgotPassword.setBackground(Color.LIGHT_GRAY);
					btnForgotPassword.setOpaque(false);
					btnForgotPassword.setContentAreaFilled(false);
					btnForgotPassword.setBorderPainted(false);
					btnForgotPassword.setBounds(443, 251, 184, 16);
					contentPane.add(btnForgotPassword);
				}
				
			}
		});
		
		
		btnForgotPassword.setBounds(443, 251, 184, 16);
		contentPane.add(btnForgotPassword);
		
		JButton btnSignIn = new JButton("Not Registered? Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSignIn.setOpaque(false);
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setContentAreaFilled(false);
		btnSignIn.setBorderPainted(false);
		btnSignIn.setBounds(443, 279, 192, 16);
		contentPane.add(btnSignIn);
	}
}
