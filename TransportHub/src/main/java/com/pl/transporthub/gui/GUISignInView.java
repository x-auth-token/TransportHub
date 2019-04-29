package com.pl.transporthub.gui;

import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.annotation.Generated;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.pl.transporthub.util.PasswordHasher;

//import com.sun.glass.ui.Window;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Window;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class GUISignInView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6871434862699855261L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPasswordField;

	/**
	 * Create the dialog.
	 */
	public GUISignInView(final Frame parent, boolean modal) {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		setBackground(Color.WHITE);
		setBounds(100, 100, 729, 420);
		setLocationRelativeTo(parent);
		contentPanel.setBounds(0, 0, 729, 420);
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setUndecorated(true);
		setModal(modal);
		getContentPane().setLayout(null);
		
		getContentPane().add(contentPanel);
		
		JButton btnSignUp = new JButton("Not Registered? Sign Up");
		btnSignUp.setBounds(452, 293, 194, 29);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignUp.setForeground(Color.GRAY);
			}
		});
		
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBounds(471, 240, 153, 29);
		btnForgotPassword.setActionCommand("Forgot");
		btnForgotPassword.setForeground(Color.WHITE);
		btnForgotPassword.setOpaque(false);
		btnForgotPassword.setContentAreaFilled(false);
		btnForgotPassword.setBorderPainted(false);
		
		
		
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent forgotButtonClicked) {
				
				//if (btnForgotPassword.getActionCommand().equals(forgotButtonClicked.getActionCommand())) {
					
					btnForgotPassword.setForeground(Color.GRAY);

				//}
				
			}
		});
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 364, 420);
			panel.setBackground(Color.LIGHT_GRAY);
			JLabel logo = new JLabel("");
			logo.setIcon(new ImageIcon(GUISignInView.class.getResource("/images/TransportHubLogo351x351New.png")));
			panel.add(logo);
			contentPanel.add(panel);
		}
		
		JLabel lblNoUserPassProvided = new JLabel("You must enter username and password");
		lblNoUserPassProvided.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoUserPassProvided.setForeground(new Color(204, 0, 0));
		lblNoUserPassProvided.setBounds(370, 216, 347, 16);
		lblNoUserPassProvided.setVisible(false);
		contentPanel.add(lblNoUserPassProvided);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(370, 81, 359, 26);
		lblUsername.setForeground(Color.WHITE);
		contentPanel.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(364, 105, 359, 38);
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setText("For guest access type anonymous");
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(370, 155, 359, 26);
		lblPassword.setForeground(Color.WHITE);
		contentPanel.add(lblPassword);
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(364, 181, 359, 38);
		contentPanel.add(txtPasswordField);
		contentPanel.add(btnForgotPassword);
		btnSignUp.setOpaque(false);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		contentPanel.add(btnSignUp);
		
		{
			
			
			JButton btnSignIn = new JButton("Sign In");
			btnSignIn.setBounds(506, 350, 87, 29);
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String username = txtUsername.getText();
					String hashedPassword = "";
					
					if (txtPasswordField.getPassword().length != 0) {
						try {
							hashedPassword = PasswordHasher.generateHashedPassword(txtPasswordField.getPassword());
						} catch (NoSuchAlgorithmException | InvalidKeySpecException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					if (username.isEmpty() || hashedPassword.isEmpty()) {
						
						lblNoUserPassProvided.setVisible(true);
						contentPanel.revalidate();
					}
					
					btnSignIn.setForeground(Color.GRAY);
					//contentPanel.revalidate();
					dispose();
//					Window win = SwingUtilities.getWindowAncestor(contentPanel);
//					win.dispose();
					
				}
			});
			btnSignIn.setForeground(Color.WHITE);
			btnSignIn.setContentAreaFilled(false);
			btnSignIn.setBorderPainted(false);
			btnSignIn.setOpaque(false);
			contentPanel.add(btnSignIn);
		
		}
		
		

	}
}
