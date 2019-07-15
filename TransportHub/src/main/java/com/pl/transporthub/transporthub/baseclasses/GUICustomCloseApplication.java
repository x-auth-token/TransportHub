package com.pl.transporthub.transporthub.baseclasses;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class GUICustomCloseApplication extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4715433703290085194L;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}

