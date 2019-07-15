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
package com.pl.transporthub.transporthub;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class GUIMainWindowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JPanel innerPanel; 

	private JLabel lblLogoLabel; 
	private GUIRoundButton btnBus; 
	private GUIRoundButton btnStation; 
	private GUIRoundButton btnRoute; 
	private GUIRoundButton btnMap; 
	private GUIRoundButton btnLogin;
	private BorderLayout brl_contentPane;
	private DefaultTableModel tblBusesModel;
	private JTable tblBuses;
	private JScrollPane scrollPane;
	private JPanel mapPanel;


	/**
	 * Create the frame.
	 */
	public GUIMainWindowView() {


		initFrame();
		initInnerPanel();
		initScrollPane();
		initContentPane();
		setUpMainWindowView();

	}


	public void initFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 655, 442);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
	}

	public void initContentPaneLayout() {
		/*
		 * gbl_contentPane = new GridBagLayout(); gbl_contentPane.columnWidths = new
		 * int[] { 10, 0, 0 }; gbl_contentPane.rowHeights = new int[] { 278, 0 };
		 * gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		 * gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		 */
		
		brl_contentPane = new BorderLayout(0, 0);
	}

	/*
	 * public void initContentPaneConstraints() { gbc_panel = new
	 * GridBagConstraints(); gbc_panel.fill = GridBagConstraints.HORIZONTAL;
	 * gbc_panel.gridwidth = 2; gbc_panel.anchor = GridBagConstraints.NORTH;
	 * gbc_panel.gridx = GridBagConstraints.REMAINDER; gbc_panel.gridy = 0;
	 * gbc_panel.weightx = 2.0; gbc_panel.weighty = 1; }
	 */

	public void initComponents() {
		lblLogoLabel = new JLabel("");
		lblLogoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLogoLabel.setIcon(new ImageIcon(GUIMainWindowView.class.getResource("/images/TransportHubTransparentLogoBWSmall2.png")));

		btnBus = GUIRoundButtonFactory.getRoundButton("Bus", "BusButton");
		btnStation = GUIRoundButtonFactory.getRoundButton("Station", "StationButton");
		btnRoute = GUIRoundButtonFactory.getRoundButton("Route", "RouteButton");
		btnMap = GUIRoundButtonFactory.getRoundButton("Map", "MapButton");
		btnLogin = GUIRoundButtonFactory.getRoundButton("Login", "LoginButton");
		
		tblBusesModel = new DefaultTableModel(10, 10);
		
		tblBuses = new JTable(tblBusesModel);
		tblBuses.setEnabled(false);
		tblBuses.getTableHeader().setReorderingAllowed(false);
	}

	public void initInnerPanel() {
		innerPanel = new JPanel();
		innerPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102, 255)));
		innerPanel.setBackground(new Color(0, 59, 77));
		innerPanel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]", "[]"));

		initComponents();
	}
	
	public void initScrollPane() {
		scrollPane = new JScrollPane(tblBuses);
	}

	public void initContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 224, 224));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));

		initContentPaneLayout();
		//initContentPaneConstraints();

		contentPane.setLayout(brl_contentPane);

	}

	public void setUpMainWindowView() {
		innerPanel.add(lblLogoLabel, "cell 0 0,alignx left,aligny center");
		innerPanel.add(btnBus, "flowx,cell 1 0,alignx center,aligny center");
		innerPanel.add(btnStation, "cell 1 0,alignx center,aligny center");
		innerPanel.add(btnRoute, "cell 1 0,alignx center,aligny center");
		innerPanel.add(btnMap, "cell 1 0,alignx center");
		innerPanel.add(btnLogin, "cell 2 0, align center");
		contentPane.add(innerPanel, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		setContentPane(contentPane);
		
	}

	public void showMainWindowView() {
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public GUIRoundButton getBtnBus() {
		return btnBus;
	}


	public GUIRoundButton getBtnStation() {
		return btnStation;
	}


	public GUIRoundButton getBtnRoute() {
		return btnRoute;
	}


	public GUIRoundButton getBtnMap() {
		return btnMap;
	}

	public GUIRoundButton getBtnLogin() {
		return btnLogin;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	/**
	 * @return the innerPanel
	 */
	public JPanel getInnerPanel() {
		return innerPanel;
	}


	/**
	 * @return the lblLogoLabel
	 */
	public JLabel getLblLogoLabel() {
		return lblLogoLabel;
	}


	/**
	 * @return the brl_contentPane
	 */
	public BorderLayout getBrl_contentPane() {
		return brl_contentPane;
	}


	/**
	 * @return the tblBusesModel
	 */
	public DefaultTableModel getTblBusesModel() {
		return tblBusesModel;
	}


	/**
	 * @return the tblBuses
	 */
	public JTable getTblBuses() {
		return tblBuses;
	}


	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}


	/**
	 * @return the mapPanel
	 */
	public JPanel getMapPanel() {
		return mapPanel;
	}
	
	

}
