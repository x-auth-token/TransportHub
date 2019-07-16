package com.pl.transporthub.transporthub.views;

import java.awt.Color;

import javax.swing.JButton;

import com.pl.transporthub.transporthub.baseclasses.GUIAbstractApplicationView;
import com.pl.transporthub.transporthub.buttons.GUIRoundBusButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButtonFactory;

public class GUIAdminView extends GUIAbstractApplicationView {
	
	private JButton btnManageUsers, btnLogs, btnCloseProgram;
	private GUIRoundButton btnLogout;
	
	public GUIAdminView() {
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
