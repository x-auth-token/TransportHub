package com.pl.transporthub.transporthub.buttons;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GUIRoundRouteButton extends GUIRoundButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5924429134116746233L;

	public GUIRoundRouteButton(String bName) {
		setName(bName); 
		setIcon(new ImageIcon(getClass().getResource("/images/TransportHubRouteButtonImageSmall.png")));
		setHorizontalAlignment(SwingConstants.CENTER);
		changeLableIconOnMouseHover();
		setText("Routes");
		setVerticalTextPosition(BOTTOM); setHorizontalTextPosition(CENTER);
		setForeground(Color.WHITE);
	}
}
