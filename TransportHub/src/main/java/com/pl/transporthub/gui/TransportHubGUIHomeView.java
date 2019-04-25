package com.pl.transporthub.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dialog;

import javax.swing.border.MatteBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class TransportHubGUIHomeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransportHubGUIHomeView frame = new TransportHubGUIHomeView();
					TransportHubGUISignInView signInDialog = new TransportHubGUISignInView();
					signInDialog.setModal(true);
					frame.setVisible(true);
					signInDialog.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TransportHubGUIHomeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 442);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {10, 0};
		gbl_contentPane.rowHeights = new int[]{278, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(30, 144, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(255, 255, 255)));
		panel.setLayout(new MigLayout("", "[132px]", "[120px][278px]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TransportHubGUIHomeView.class.getResource("/images/TransportHubLogo100x100WhiteTransparent.png")));
		panel.add(lblNewLabel, "cell 0 0,alignx center,aligny top");
		panel.add(panel_1, "cell 0 1,grow");
		
		JButton btnBuses = new JButton("Buses");
		btnBuses.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuses.setForeground(Color.WHITE);
		btnBuses.setContentAreaFilled(false);
		btnBuses.setBorderPainted(false);
		btnBuses.setOpaque(false);
		
		
		
		btnBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnStations = new JButton("Stations");
		btnStations.setHorizontalAlignment(SwingConstants.LEFT);
		btnStations.setForeground(Color.WHITE);
		btnStations.setContentAreaFilled(false);
		btnStations.setBorderPainted(false);
		btnStations.setOpaque(false);
		
		
		JButton btnRoutes = new JButton("Routes");
		btnRoutes.setHorizontalAlignment(SwingConstants.LEFT);
		btnRoutes.setForeground(Color.WHITE);
		btnRoutes.setContentAreaFilled(false);
		btnRoutes.setBorderPainted(false);
		btnRoutes.setOpaque(false);
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnStations))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRoutes))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnBuses)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnBuses)
					.addGap(5)
					.addComponent(btnStations)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRoutes)
					.addContainerGap(159, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		
	}
}
