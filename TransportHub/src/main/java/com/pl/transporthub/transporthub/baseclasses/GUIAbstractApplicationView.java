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


		protected void initFrame() {
			appFrame = new JFrame();
			appFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			appFrame.setBounds(100, 100, 655, 442);
			appFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			appFrame.setUndecorated(true);
		}

		protected void initContentPaneLayout() {
			brl_contentPane = new BorderLayout(0, 0);
		}

		protected void initComponents() {
			lblLogoLabel = new JLabel("");
			lblLogoLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblLogoLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			lblLogoLabel.setIcon(new ImageIcon(GUIMainWindowView.class.getResource("/images/TransportHubTransparentLogoBWSmall2.png")));

		}

		protected void initInnerPanel() {
			innerPanel = new JPanel();
			innerPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(51, 102, 255)));
			innerPanel.setBackground(new Color(0, 59, 77));
			innerPanel.setLayout(new MigLayout("", "[][287px,grow][][][][][][][][][]", "[]"));

			initComponents();
		}

		protected void initScrollPane() {
			
		}

		protected void initContentPane() {
			contentPane = new JPanel();
			contentPane.setBackground(new Color(222, 224, 224));
			contentPane.setBorder(new LineBorder(new Color(192, 192, 192)));

			initContentPaneLayout();
			

			contentPane.setLayout(brl_contentPane);

		}

		protected void setUpMainWindowView() {
			innerPanel.add(lblLogoLabel, "cell 0 0,alignx left,aligny center");

			contentPane.add(innerPanel, BorderLayout.NORTH);
			//contentPane.add(scrollPane, BorderLayout.CENTER);
			appFrame.setContentPane(contentPane);

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
		
		public void hideAppWindow() {
			appFrame.setVisible(false);
		}
		
		public void showAppWindow() {
			appFrame.setVisible(true);
		}
		
		public void closeAppWindow() {
			appFrame.dispose();
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}


	



}
