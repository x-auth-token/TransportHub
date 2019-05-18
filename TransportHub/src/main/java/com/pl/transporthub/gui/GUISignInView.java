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
package com.pl.transporthub.gui;

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
import com.pl.transporthub.util.PasswordHasher;

//import com.sun.glass.ui.Window;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class GUISignInView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6871434862699855261L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPasswordField;
	private boolean firstRun = true;

	/**
	 * Create the dialog.
	 */
	public GUISignInView(final Frame parent, boolean modal) {
		setUndecorated(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(true);
		setBackground(Color.WHITE);
		setBounds(100, 100, 729, 327);
		setLocationRelativeTo(parent);
		contentPanel.setBounds(0, 0, 729, 327);
		contentPanel.setBackground(new Color(222, 224, 224));
		contentPanel.setBorder(new LineBorder(new Color(128, 128, 128)));

		getContentPane().setLayout(null);

		JButton btnSignUp = new JButton("Not Registered? Sign Up");
		btnSignUp.setBounds(452, 243, 194, 29);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSignUp.setForeground(Color.GRAY);
			}
		});

		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setBounds(472, 203, 153, 29);
		btnForgotPassword.setActionCommand("Forgot");
		btnForgotPassword.setForeground(Color.BLACK);
		btnForgotPassword.setOpaque(false);
		btnForgotPassword.setContentAreaFilled(false);
		btnForgotPassword.setBorderPainted(false);

		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent forgotButtonClicked) {

				// if
				// (btnForgotPassword.getActionCommand().equals(forgotButtonClicked.getActionCommand()))
				// {

				btnForgotPassword.setForeground(Color.GRAY);

				// }

			}
		});
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(128, 128, 128)));
			panel.setBounds(0, 0, 364, 327);
			panel.setBackground(new Color(0, 59, 77));
			JLabel logo = new JLabel("");
			logo.setBackground(new Color(102, 0, 204));
			logo.setIcon(new ImageIcon(GUISignInView.class.getResource("/images/TransportHubLogoBWBig.png")));
			panel.add(logo);
			contentPanel.add(panel);
		}

		JLabel lblNoUserPassProvided = new JLabel("You must enter username and password");
		lblNoUserPassProvided.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoUserPassProvided.setForeground(new Color(204, 0, 51));
		lblNoUserPassProvided.setBounds(372, 176, 347, 16);
		lblNoUserPassProvided.setVisible(false);
		contentPanel.add(lblNoUserPassProvided);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(374, 48, 359, 26);
		lblUsername.setForeground(Color.BLACK);
		contentPanel.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setBounds(374, 75, 345, 26);

		txtUsername.setColumns(10);
		txtUsername.setBackground(Color.WHITE);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(374, 112, 359, 26);
		lblPassword.setForeground(Color.BLACK);
		contentPanel.add(lblPassword);

		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(374, 139, 345, 26);
		contentPanel.add(txtPasswordField);

		contentPanel.add(btnForgotPassword);
		btnSignUp.setOpaque(false);
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		contentPanel.add(btnSignUp);

		{
			String sGuestAccess = "For Guest access type guest/guest";

			JButton btnSignIn = new JButton("Sign In");
			btnSignIn.setBounds(502, 283, 87, 29);
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

					if (username.isEmpty() || hashedPassword.isEmpty() || username.equals(sGuestAccess)) {

						if (!lblNoUserPassProvided.isVisible())
							lblNoUserPassProvided.setVisible(true);

					} else {
						dispose();
					}

				}
			});

			txtUsername.addFocusListener(new FocusListener() {

				@Override
				public void focusLost(FocusEvent e) {

					if (txtUsername.getText().equals("")) {
						txtUsername.setText(sGuestAccess);
						txtUsername.setForeground(Color.LIGHT_GRAY);
						txtUsername.revalidate();
					}

				}

				@Override
				public void focusGained(FocusEvent e) {
					if (isFirstRun()) {
						txtUsername.setText(sGuestAccess);
						txtUsername.setForeground(Color.LIGHT_GRAY);
						setFirstRun(false);
						txtUsername.transferFocus();

					} else {
						if (txtUsername.getText().equals(sGuestAccess)) {
							txtUsername.setText("");
							txtUsername.setForeground(Color.BLACK);
							txtUsername.revalidate();
						}
					}

				}
			});

			contentPanel.add(txtUsername);
			btnSignIn.setForeground(Color.BLACK);
			btnSignIn.setContentAreaFilled(false);
			btnSignIn.setBorderPainted(false);
			btnSignIn.setOpaque(false);
			contentPanel.add(btnSignIn);

			getContentPane().add(contentPanel);

			JLabel lblCloseWindow = new JLabel("");
			lblCloseWindow.setHorizontalAlignment(SwingConstants.CENTER);
			lblCloseWindow.setIcon(new ImageIcon(
					GUISignInView.class.getResource("/images/TansportHubCloseWindowButtomImageSmall.png")));
			lblCloseWindow.setBounds(705, 6, 14, 16);

			lblCloseWindow.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					dispose();

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
			contentPanel.add(lblCloseWindow);

			setModal(modal);

		}

	}

	public boolean isFirstRun() {
		return firstRun;
	}

	public void setFirstRun(boolean firstRun) {
		this.firstRun = firstRun;
	}
}
