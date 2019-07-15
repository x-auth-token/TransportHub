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

import com.pl.transporthub.transporthub.baseclasses.GUIBaseApplicationView;
import com.pl.transporthub.transporthub.buttons.GUIRoundButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButtonFactory;

import net.miginfocom.swing.MigLayout;

public class GUIMainWindowView extends GUIBaseApplicationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GUIRoundButton btnLogin;
	/**
	 * Create the frame.
	 */
	public GUIMainWindowView() {

		super();
	
	}

	@Override
	public void initComponents() {
		btnLogin = GUIRoundButtonFactory.getRoundButton("Login", "LoginButton");
		super.initComponents();
		
	

	}
	@Override
	public void setUpMainWindowView() {
		getInnerPanel().add(btnLogin,"cell 2 0, align center");
		
		super.setUpMainWindowView();
	}
	
	public GUIRoundButton getBtnLogin() {
		return btnLogin;
	}
	
}