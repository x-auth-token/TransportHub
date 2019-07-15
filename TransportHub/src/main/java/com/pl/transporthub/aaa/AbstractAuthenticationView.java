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

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


//import com.sun.glass.ui.Window;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public abstract class AbstractAuthenticationView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6871434862699855261L;
	private JPanel contentPanel = new JPanel();
	
	protected JPanel logoBackgroundPanel;
	protected JLabel lblCloseWindow;
	protected JLabel logo;
	

	/**
	 * Create the dialog.
	 */
	public AbstractAuthenticationView(final Frame parent, boolean modal) {
		
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
		
		
		lblCloseWindow = new JLabel("");
		lblCloseWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseWindow.setIcon(new ImageIcon(
				AbstractAuthenticationView.class.getResource("/images/TansportHubCloseWindowButtomImageSmall.png")));
		lblCloseWindow.setBounds(705, 6, 14, 16);
		
		logoBackgroundPanel = new JPanel();
		logoBackgroundPanel.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(128, 128, 128)));
		logoBackgroundPanel.setBounds(0, 0, 364, 327);
		logoBackgroundPanel.setBackground(new Color(0, 59, 77));
		
		
		logo = new JLabel("");
		logo.setBackground(new Color(102, 0, 204));
		logo.setIcon(new ImageIcon(AbstractAuthenticationView.class.getResource("/images/TransportHubLogoBWBig.png")));
		
		contentPanel.setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		
	}
	
	public void setUpAuthenticationView() {
		
		logoBackgroundPanel.add(logo);
		contentPanel.add(logoBackgroundPanel);
		
		contentPanel.add(lblCloseWindow);
		
		
	}
	

	public JPanel getContentPanel() {
		return contentPanel;
		
	}
	
	public void setContentPanel(JPanel panel) {
		this.contentPanel = panel;
	}

	

	public JPanel getLogoBackgroundPanel() {
		return logoBackgroundPanel;
	}


	public void setLogoBackgroundPanel(JPanel logoBackgroundPanel) {
		this.logoBackgroundPanel = logoBackgroundPanel;
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



	public void showAuthView() {
		setVisible(true);
	}
	
	public void exit() {
		dispose();
	}
	
}
