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
package com.pl.transporthub.transporthub.views;

import java.awt.Color;

import javax.swing.JButton;

import com.pl.transporthub.transporthub.baseclasses.GUIAbstractApplicationView;
import com.pl.transporthub.transporthub.buttons.GUIRoundBusButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButtonFactory;

public class GUIDriverView extends GUIAbstractApplicationView {
	
	private JButton btnManageUsers, btnLogs, btnCloseProgram;
	private GUIRoundButton btnLogout;
	
	public GUIDriverView() {
		super();
		
	}

	@Override
	public void initComponents() {
		
		super.initComponents();
		btnManageUsers = new JButton("User Management");
		btnManageUsers.setActionCommand("usrmng");
		btnManageUsers.setForeground(Color.WHITE);
		btnManageUsers.setOpaque(false);
		btnManageUsers.setContentAreaFilled(false);
		btnManageUsers.setBorderPainted(false);
		
		btnLogs = new JButton("Logs");
		btnLogs.setActionCommand("viewLogs");
		btnLogs.setForeground(Color.WHITE);
		btnLogs.setOpaque(false);
		btnLogs.setContentAreaFilled(false);
		btnLogs.setBorderPainted(false);
	
		
		btnCloseProgram = new JButton("Close Program");
		btnCloseProgram.setActionCommand("closeProgram");
		btnCloseProgram.setForeground(Color.WHITE);
		btnCloseProgram.setOpaque(false);
		btnCloseProgram.setContentAreaFilled(false);
		btnCloseProgram.setBorderPainted(false);
		
		btnLogout = GUIRoundButtonFactory.getRoundButton("Logout", "LogoutButton");
		
	}

	@Override
	public void initInnerPanel() {
		// TODO Auto-generated method stub
		super.initInnerPanel();
		getInnerPanel().add(btnManageUsers, "flowx,cell 1 0,alignx center,aligny center");
		getInnerPanel().add(btnLogs, "flowx,cell 1 0,alignx center,aligny center");
		getInnerPanel().add(btnCloseProgram, "flowx,cell 1 0,alignx center,aligny center");
		getInnerPanel().add(btnLogout, "cell 2 0, align center");
		
		
		
	}

	@Override
	public void initScrollPane() {
		// TODO Auto-generated method stub
		super.initScrollPane();
	}

	@Override
	public void setUpMainWindowView() {
		// TODO Auto-generated method stub
		super.setUpMainWindowView();
	}

	public JButton getBtnManageUsers() {
		return btnManageUsers;
	}

	public void setBtnManageUsers(JButton manageUsers) {
		this.btnManageUsers = manageUsers;
	}

	public JButton getBtnLogs() {
		return btnLogs;
	}

	public void setBtnLogs(JButton logs) {
		this.btnLogs = logs;
	}

	public JButton getBtnCloseProgram() {
		return btnCloseProgram;
	}

	public void setBtnCloseProgram(JButton closeProgram) {
		this.btnCloseProgram = closeProgram;
	}

	public GUIRoundButton getBtnLogout() {
		return btnLogout;
	}

	
	
	
}
