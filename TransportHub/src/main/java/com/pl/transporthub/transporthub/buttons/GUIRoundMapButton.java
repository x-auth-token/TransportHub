package com.pl.transporthub.transporthub.buttons;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GUIRoundMapButton extends GUIRoundButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6384442326629645015L;

	public GUIRoundMapButton(String bName) {
		setName(bName); 
		setIcon(new ImageIcon(getClass().getResource("/images/TransportHubMapButtonImageSmall.png")));
		setHorizontalAlignment(SwingConstants.CENTER);
		changeLableIconOnMouseHover();
		setText("Map");
		setVerticalTextPosition(BOTTOM); setHorizontalTextPosition(CENTER);
		setForeground(Color.WHITE);
	}
}
