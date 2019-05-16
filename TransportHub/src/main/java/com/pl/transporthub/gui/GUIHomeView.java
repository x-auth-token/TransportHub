package com.pl.transporthub.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.BorderLayout;

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
		//panel.setBackground(Color.LIGHT_GRAY);
		panel.setBackground(new Color(0, 59, 77));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = GridBagConstraints.REMAINDER;
		gbc_panel.gridy = 0;
		gbc_panel.weightx = 2.0;
		gbc_panel.weighty = 1;
		contentPane.add(panel, gbc_panel);
						panel.setLayout(new MigLayout("", "[150px][287px][][][]", "[150px]"));
				
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
						lblNewLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
						lblNewLabel.setIcon(
								new ImageIcon(GUIHomeView.class.getResource("/images/TransportHubTransparentLogo150x150.png")));
		panel.add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		
		JLabel lblBusButton = new JLabel("");
		lblBusButton.setIcon(new ImageIcon(GUIHomeView.class.getResource("/images/TransportHubTransparentBusButtonImage150x150.png")));
		lblBusButton.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBusButton, "cell 2 0");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(GUIHomeView.class.getResource("/images/TransportHubTransparentBusButtonImage150x150.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label, "cell 3 0");
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(GUIHomeView.class.getResource("/images/TransportHubTransparentBusButtonImage150x150.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1, "cell 4 0");
 

 

		  
		  
		  contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("shift ctrl pressed E"), "Exit");
		  contentPane.getActionMap().put("Exit", close);
		  //GUISignInView signInView = new GUISignInView(this, true);
		  
		  this.setVisible(true);
		 
		  //signInView.setVisible(true);
	}
}

