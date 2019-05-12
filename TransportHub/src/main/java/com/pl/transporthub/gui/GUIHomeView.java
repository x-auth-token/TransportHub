package com.pl.transporthub.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;

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
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 10, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 278, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
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
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setBackground(new Color(51, 0, 102));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		//gbc_panel.weightx = 1.0;
		//gbc_panel.weighty = 1.0;
		contentPane.add(panel, gbc_panel);

		JPanel panel_1 = new JPanel();
		//panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBackground(new Color(51, 0, 102));
		panel_1.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(255, 255, 255)));
		panel.setLayout(new MigLayout("", "[132px]", "[120px][278px]"));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(
				new ImageIcon(GUIHomeView.class.getResource("/images/BW Transparent 150x150.png")));
				//new ImageIcon(GUIHomeView.class.getResource("/images/TransportHubLogo100x100.png")));
		panel.add(lblNewLabel, "cell 0 0,alignx center,aligny top");
		panel.add(panel_1, "cell 0 1,grow");

		
		  JButton btnBuses = new JButton("Buses");
		  btnBuses.setFont(new Font("Tahoma", Font.BOLD, 16));
		  btnBuses.setBackground(new Color(255, 255, 255));
		  btnBuses.setHorizontalAlignment(SwingConstants.LEFT);
		  btnBuses.setForeground(new Color(255, 255, 255)); 
		  //btnBuses.setForeground(new Color(39, 44, 91)); 
		  btnBuses.setContentAreaFilled(false);
		  btnBuses.setBorderPainted(false); btnBuses.setOpaque(false);
		  
		  
		  
		  btnBuses.addActionListener(new ActionListener() { public void
		  actionPerformed(ActionEvent e) { } });
		  
		  JButton btnStations = new JButton("Stations");
		  btnStations.setFont(new Font("Tahoma", Font.BOLD, 16));
		  btnStations.setHorizontalAlignment(SwingConstants.LEFT);
		  btnStations.setForeground(new Color(255, 255, 255));
		  btnStations.setContentAreaFilled(false); btnStations.setBorderPainted(false);
		  btnStations.setOpaque(false);
		  
		  
		  JButton btnRoutes = new JButton("Routes");
		  btnRoutes.setFont(new Font("Tahoma", Font.BOLD, 16));
		  btnRoutes.setHorizontalAlignment(SwingConstants.LEFT);
		  btnRoutes.setForeground(new Color(255, 255, 255)); btnRoutes.setContentAreaFilled(false);
		  btnRoutes.setBorderPainted(false); btnRoutes.setOpaque(false);
		  
		  
		  GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		  gl_panel_1.setHorizontalGroup(
		  gl_panel_1.createParallelGroup(Alignment.LEADING)
		  .addGroup(gl_panel_1.createSequentialGroup()
		  .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		  .addGroup(gl_panel_1.createSequentialGroup() .addContainerGap()
		  .addComponent(btnStations)) .addGroup(gl_panel_1.createSequentialGroup()
		  .addContainerGap() .addComponent(btnRoutes))
		  .addGroup(gl_panel_1.createSequentialGroup() .addContainerGap()
		  .addComponent(btnBuses))) .addContainerGap(19, Short.MAX_VALUE)) );
		  gl_panel_1.setVerticalGroup(
		  gl_panel_1.createParallelGroup(Alignment.LEADING)
		  .addGroup(gl_panel_1.createSequentialGroup() .addContainerGap()
		  .addComponent(btnBuses) .addGap(5) .addComponent(btnStations)
		  .addPreferredGap(ComponentPlacement.RELATED) .addComponent(btnRoutes)
		  .addContainerGap(159, Short.MAX_VALUE)) ); panel_1.setLayout(gl_panel_1);
 

 

		  
		  
		  contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift ctrl pressed E"), "Exit");
		  contentPane.getActionMap().put("Exit", close);
		  GUISignInView signInView = new GUISignInView(this, true);
		  this.setVisible(true); signInView.setVisible(true);
		 

	}
}
