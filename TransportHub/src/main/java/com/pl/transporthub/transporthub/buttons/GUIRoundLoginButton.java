package com.pl.transporthub.transporthub.buttons;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GUIRoundLoginButton extends GUIRoundButton {

	public GUIRoundLoginButton(String bName) {
		setName(bName); 
		setIcon(new ImageIcon(getClass().getResource("/images/TransportHubLoginButtonImageSmall.png")));
		setHorizontalAlignment(SwingConstants.CENTER);
		changeLableIconOnMouseHover();
		setText("Login");
		setVerticalTextPosition(BOTTOM); setHorizontalTextPosition(CENTER);
		setForeground(Color.WHITE);
	}
}
