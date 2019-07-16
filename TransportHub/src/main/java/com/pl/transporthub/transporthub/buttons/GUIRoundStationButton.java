package com.pl.transporthub.transporthub.buttons;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GUIRoundStationButton extends GUIRoundButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6217219783236271014L;

	public GUIRoundStationButton(String bName) {
		setName(bName); 
		setIcon(new ImageIcon(getClass().getResource("/images/TransportHubStationButtonImageSmall.png")));
		setHorizontalAlignment(SwingConstants.CENTER);
		changeLableIconOnMouseHover();
		setText("Stations");
		setVerticalTextPosition(BOTTOM); setHorizontalTextPosition(CENTER);
		setForeground(Color.WHITE);
	}
}
