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
package com.pl.transporthub.aaa.baseclasses;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Frame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 * 
 *  Abstract Class that defines a skeleton of 
 *  Authentication User Interface View
 * @author pavelm
 * 
 *	
 */
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
	/**
	 * @param parent
	 * @param modal
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
	
	/**
	 * 
	 */
	public void exit() {
		dispose();
	}
	
}
