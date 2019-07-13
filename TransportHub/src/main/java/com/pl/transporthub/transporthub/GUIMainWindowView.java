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
	private JLabel lblLogoLabel; 
	private GUIRoundButton rbBus; 
	private GUIRoundButton rbStation; 
	private GUIRoundButton rbRoute; 
	private GUIRoundButton rbMap; 
	private GUIRoundButton rbLogin;


	/**
	 * Create the frame.
	 */
	public GUIMainWindowView() {


		initFrame();
		initInnerPanel();
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
		gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 10, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 278, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
	}

	public void initContentPaneConstraints() {
		gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = GridBagConstraints.REMAINDER;
		gbc_panel.gridy = 0;
		gbc_panel.weightx = 2.0;
		gbc_panel.weighty = 1;
	}

	public void initComponents() {
		lblLogoLabel = new JLabel("");
		lblLogoLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblLogoLabel.setIcon(new ImageIcon(GUIMainWindowView.class.getResource("/images/TransportHubTransparentLogoBWSmall2.png")));

		rbBus = GUIRoundButtonFactory.getRoundButton("Bus", "BusButton");
		rbStation = GUIRoundButtonFactory.getRoundButton("Station", "StationButton");
		rbRoute = GUIRoundButtonFactory.getRoundButton("Route", "RouteButton");
		rbMap = GUIRoundButtonFactory.getRoundButton("Map", "MapButton");
		rbLogin = GUIRoundButtonFactory.getRoundButton("Login", "LoginButton");
	}

	public void initInnerPanel() {
		innerPanel = new JPanel();
		innerPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102, 255)));
		innerPanel.setBackground(new Color(0, 59, 77));
		innerPanel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]", "[]"));

		initComponents();
	}

	public void initContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 224, 224));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));

		initContentPaneLayout();
		initContentPaneConstraints();

		contentPane.setLayout(gbl_contentPane);

	}

	public void setUpMainWindowView() {
		innerPanel.add(lblLogoLabel, "cell 0 0,alignx left,aligny center");
		innerPanel.add(rbBus, "flowx,cell 1 0,alignx center,aligny center");
		innerPanel.add(rbStation, "cell 1 0,alignx center,aligny center");
		innerPanel.add(rbRoute, "cell 1 0,alignx center,aligny center");
		innerPanel.add(rbMap, "cell 1 0,alignx center");
		innerPanel.add(rbLogin, "cell 2 0, align center");
		contentPane.add(innerPanel, gbc_panel);
		setContentPane(contentPane);
	}

	public void showMainWindowView() {
		setVisible(true);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public GUIRoundButton getRbBus() {
		return rbBus;
	}


	public GUIRoundButton getRbStation() {
		return rbStation;
	}


	public GUIRoundButton getRbRoute() {
		return rbRoute;
	}


	public GUIRoundButton getRbMap() {
		return rbMap;
	}

	public GUIRoundButton getRbLogin() {
		return rbLogin;
	}

}
