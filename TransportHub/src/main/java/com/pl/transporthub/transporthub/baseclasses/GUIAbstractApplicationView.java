package com.pl.transporthub.transporthub.baseclasses;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import com.pl.transporthub.transporthub.views.GUIMainWindowView;

import net.miginfocom.swing.MigLayout;

public class GUIAbstractApplicationView {

		private static final long serialVersionUID = 1L;
		private JPanel contentPane, innerPanel;
		private JFrame appFrame;

		private JLabel lblLogoLabel; 
		private BorderLayout brl_contentPane;
		
		private JScrollPane scrollPane;



		/**
		 * Create the frame.
		 */
		public GUIAbstractApplicationView() {


			initFrame();
			initInnerPanel();
			initScrollPane();
			initContentPane();
			setUpMainWindowView();

		}


		public void initFrame() {
			appFrame = new JFrame();
			appFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			appFrame.setBounds(100, 100, 655, 442);
			appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			appFrame.setUndecorated(true);
		}

		public void initContentPaneLayout() {
			brl_contentPane = new BorderLayout(0, 0);
		}

		public void initComponents() {
			lblLogoLabel = new JLabel("");
			lblLogoLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblLogoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			lblLogoLabel.setIcon(new ImageIcon(GUIMainWindowView.class.getResource("/images/TransportHubTransparentLogoBWSmall2.png")));

		}

		public void initInnerPanel() {
			innerPanel = new JPanel();
			innerPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102, 255)));
			innerPanel.setBackground(new Color(0, 59, 77));
			innerPanel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]", "[]"));

			initComponents();
		}

		public void initScrollPane() {
			
		}

		public void initContentPane() {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(222, 224, 224));
			contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));

			initContentPaneLayout();
			

			contentPane.setLayout(brl_contentPane);

		}

		public void setUpMainWindowView() {
			innerPanel.add(lblLogoLabel, "cell 0 0,alignx left,aligny center");

			contentPane.add(innerPanel, BorderLayout.NORTH);
			//contentPane.add(scrollPane, BorderLayout.CENTER);
			appFrame.setContentPane(contentPane);

		}

		public void showAppWindowView() {
			appFrame.setVisible(true);
		}

		public JPanel getContentPane() {
			return contentPane;
		}

		

		/*
		 * public GUIRoundButton getBtnLogin() { return btnLogin; }
		 */

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
		

		/**
		 * @return the scrollPane
		 */
		public JScrollPane getScrollPane() {
			return scrollPane;
		}

		public JFrame getAppFrame() {
			return appFrame;
		}


		public static long getSerialversionuid() {
			return serialVersionUID;
		}


	



}
