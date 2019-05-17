package com.pl.transporthub.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.BorderLayout;

import com.pl.transporthub.gui.GUIRoundButton;

public class GUIHomeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUIHomeView() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 655, 442);
		setExtendedState(MAXIMIZED_BOTH);
		// setUndecorated(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(222, 224, 224));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 10, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 278, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// Custom close action
		class CloseApplication extends AbstractAction {

			/**
			 * 
			 */
			private static final long serialVersionUID = -4715433703290085194L;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		}

		Action close = new CloseApplication();

		// Hidden keyboard shortcut that closes the app

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102, 255)));

		panel.setBackground(new Color(0, 59, 77));

		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridwidth = 2;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = GridBagConstraints.REMAINDER;
		gbc_panel.gridy = 0;
		gbc_panel.weightx = 2.0;
		gbc_panel.weighty = 1;

		contentPane.add(panel, gbc_panel);
		//panel.setLayout(new MigLayout("", "[150px][287px,grow][][][][][][][][][]", "[150px,grow]"));
		panel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]", "[]"));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel.setIcon(
				new ImageIcon(GUIHomeView.class.getResource("/images/TransportHubTransparentLogoBWSmall2.png")));
		panel.add(lblNewLabel, "cell 0 0,alignx left,aligny center");

		GUIRoundButton rbBus = new GUIRoundButton("BusButton", "/images/TransportHubBusButtonImageSmall.png", "Buses");

		panel.add(rbBus, "flowx,cell 1 0,alignx center,aligny center");
		GUIRoundButton rbStation = new GUIRoundButton("StationButton",
				"/images/TransportHubStationButtonImageSmall.png", "Stations");
		panel.add(rbStation, "cell 1 0,alignx center,aligny center");
		GUIRoundButton rbRoute = new GUIRoundButton("RouteButton", "/images/TransportHubRouteButtonImageSmall.png", "Routes");
		panel.add(rbRoute, "cell 1 0,alignx center,aligny center");
		GUIRoundButton rbMap = new GUIRoundButton("MapButton", "/images/TransportHubMapButtonImageSmall.png", "Map");
		panel.add(rbMap, "cell 1 0,alignx center");
		
		GUIRoundButton rbLogin = new GUIRoundButton("LoginButton", "/images/TransportHubLoginButtonImageSmall.png", "Login");
		rbLogin.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				GUISignInView signIn = new GUISignInView(null, true);
				signIn.setVisible(true);
				
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
		panel.add(rbLogin, "cell 2 0, align center");

		contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift ctrl pressed E"),"Exit");
		contentPane.getActionMap().put("Exit", close);
		// GUISignInView signInView = new GUISignInView(this, true);

		this.setVisible(true);

		// signInView.setVisible(true);
	}

}
