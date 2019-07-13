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

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.pl.transporthub.aaa.AuthenticationController;
import com.pl.transporthub.aaa.AuthenticationView;

import net.miginfocom.swing.MigLayout;

public class GUIMainWindowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GridBagLayout gbl_contentPane;
	private JPanel innerPanel;
	private GridBagConstraints gbc_panel;
	private JLabel lblNewLabel;
	private GUIRoundButton rbBus;
	private GUIRoundButton rbStation;
	private GUIRoundButton rbRoute;
	private GUIRoundButton rbMap;
	private GUIRoundButton rbLogin;

	/**
	 * Create the frame.
	 */
	public GUIMainWindowView() {
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 655, 442);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 224, 224));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		
		
		
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 10, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 278, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		
		contentPane.setLayout(gbl_contentPane);
		
		innerPanel = new JPanel();
		innerPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102, 255)));
		innerPanel.setBackground(new Color(0, 59, 77));
		
		gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = GridBagConstraints.REMAINDER;
		gbc_panel.gridy = 0;
		gbc_panel.weightx = 2.0;
		gbc_panel.weighty = 1;
		
		contentPane.add(innerPanel, gbc_panel);
		
		innerPanel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]", "[]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel.setIcon(new ImageIcon(GUIMainWindowView.class.getResource("/images/TransportHubTransparentLogoBWSmall2.png")));
		
		innerPanel.add(lblNewLabel, "cell 0 0,alignx left,aligny center");
		
		rbBus = GUIRoundButtonFactory.getRoundButton("Bus", "BusButton");
		
		rbStation = GUIRoundButtonFactory.getRoundButton("Station", "StationButton");
		rbRoute = GUIRoundButtonFactory.getRoundButton("Route", "RouteButton");
		rbMap = GUIRoundButtonFactory.getRoundButton("Map", "MapButton");
		rbLogin = GUIRoundButtonFactory.getRoundButton("Login", "LoginButton");
		
		
		innerPanel.add(rbBus, "flowx,cell 1 0,alignx center,aligny center");
		innerPanel.add(rbStation, "cell 1 0,alignx center,aligny center");
		innerPanel.add(rbRoute, "cell 1 0,alignx center,aligny center");
		innerPanel.add(rbMap, "cell 1 0,alignx center");
		innerPanel.add(rbLogin, "cell 2 0, align center");
		  
		setContentPane(contentPane); 
		validate();
		setVisible(true);
	}

	public void initFrame() {
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 655, 442);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(false);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 224, 224));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		
		setContentPane(contentPane);
		
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 10, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 278, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		
		contentPane.setLayout(gbl_contentPane);
		
		innerPanel = new JPanel();
		innerPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102, 255)));
		innerPanel.setBackground(new Color(0, 59, 77));
		
		gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = GridBagConstraints.REMAINDER;
		gbc_panel.gridy = 0;
		gbc_panel.weightx = 2.0;
		gbc_panel.weighty = 1;
		
		contentPane.add(innerPanel, gbc_panel);
		
		innerPanel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]", "[]"));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel.setIcon(new ImageIcon(GUIMainWindowView.class.getResource("/images/TransportHubTransparentLogoBWSmall2.png")));
		
		innerPanel.add(lblNewLabel, "cell 0 0,alignx left,aligny center");
		
		rbBus = GUIRoundButtonFactory.getRoundButton("Bus", "BusButton");
		
		rbStation = GUIRoundButtonFactory.getRoundButton("Station", "StationButton");
		rbRoute = GUIRoundButtonFactory.getRoundButton("Route", "RouteButton");
		rbMap = GUIRoundButtonFactory.getRoundButton("Map", "MapButton");
		rbLogin = GUIRoundButtonFactory.getRoundButton("Login", "LoginButton");
		
		
		innerPanel.add(rbBus, "flowx,cell 1 0,alignx center,aligny center");
		innerPanel.add(rbStation, "cell 1 0,alignx center,aligny center");
		innerPanel.add(rbRoute, "cell 1 0,alignx center,aligny center");
		innerPanel.add(rbMap, "cell 1 0,alignx center");
		innerPanel.add(rbLogin, "cell 2 0, align center");
		
		
	}

	public void initContentPane() {
		
		
		initContentPaneLayout();
		initInnerPanel();
		
	}

	public void initContentPaneLayout() {
		
	}

	public void initInnerPanel() {
		
		
		initGridBagConstraints();
		

	}

	public void initGridBagConstraints() {
		
	}

	public void initComponents() {
		
		
	}

	public void setUpMainWindowView() {
		
		
		
		
		
		
		
		
		
	
	}

	public void showMainWindowView() {
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public GridBagLayout getGbl_contentPane() {
		return gbl_contentPane;
	}

	public void setGbl_contentPane(GridBagLayout gbl_contentPane) {
		this.gbl_contentPane = gbl_contentPane;
	}

	public JPanel getPanel() {
		return innerPanel;
	}

	public void setPanel(JPanel panel) {
		this.innerPanel = panel;
	}

	public GridBagConstraints getGbc_panel() {
		return gbc_panel;
	}

	public void setGbc_panel(GridBagConstraints gbc_panel) {
		this.gbc_panel = gbc_panel;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}

	public GUIRoundButton getRbBus() {
		return rbBus;
	}

	public void setRbBus(GUIRoundButton rbBus) {
		this.rbBus = rbBus;
	}

	public GUIRoundButton getRbStation() {
		return rbStation;
	}

	public void setRbStation(GUIRoundButton rbStation) {
		this.rbStation = rbStation;
	}

	public GUIRoundButton getRbRoute() {
		return rbRoute;
	}

	public void setRbRoute(GUIRoundButton rbRoute) {
		this.rbRoute = rbRoute;
	}

	public GUIRoundButton getRbMap() {
		return rbMap;
	}

	public void setRbMap(GUIRoundButton rbMap) {
		this.rbMap = rbMap;
	}

	public GUIRoundButton getRbLogin() {
		return rbLogin;
	}

	public void setRbLogin(GUIRoundButton rbLogin) {
		this.rbLogin = rbLogin;
	}

}
