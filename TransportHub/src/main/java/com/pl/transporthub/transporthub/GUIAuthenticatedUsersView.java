package com.pl.transporthub.transporthub;

import java.awt.BorderLayout;

import javax.swing.JTable;

import com.pl.transporthub.transporthub.baseclasses.GUIBaseApplicationView;
import com.pl.transporthub.transporthub.buttons.GUIRoundButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButtonFactory;
import com.pl.transporthub.user.User;

public class GUIAuthenticatedUsersView extends GUIBaseApplicationView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GUIRoundButton btnLogout;

	public GUIAuthenticatedUsersView() {
		super();
		
	}

	@Override
	public void initComponents() {
		btnLogout = GUIRoundButtonFactory.getRoundButton("Logout", "LogoutButton");
		super.initComponents();
		
	}

	@Override
	public void setUpMainWindowView() {
		getInnerPanel().add(btnLogout, "cell 2 0, align center");
		super.setUpMainWindowView();
	}

	/**
	 * @return the btnLogout
	 */
	public GUIRoundButton getBtnLogout() {
		return btnLogout;
	}
	
	
	
	
	
}
