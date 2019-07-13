package com.pl.transporthub.gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

class GUICustomCloseApplication extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4715433703290085194L;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}

