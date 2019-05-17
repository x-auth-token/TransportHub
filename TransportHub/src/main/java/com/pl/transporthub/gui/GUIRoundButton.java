package com.pl.transporthub.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUIRoundButton extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1108283401029565569L;
	
	

	public GUIRoundButton(String btnName, String btnIconName) {
		this.setName(btnName);
		this.setIcon(new ImageIcon(getClass().getResource(btnIconName)));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		changeLableIconOnMouseHover();
	}
	
	public GUIRoundButton(String btnName, String btnIconName, String btntext) {
		
		this(btnName, btnIconName);
		setText(btntext);
		setVerticalTextPosition(BOTTOM);
		setHorizontalTextPosition(CENTER);
		setForeground(Color.WHITE);
		//setTextA
	}

	public void changeLableIconOnMouseHover() {

		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				setIcon(new ImageIcon(
						GUIHomeView.class.getResource("/images/TransportHub" + getName() + "ImageBig.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setIcon(new ImageIcon(
						GUIHomeView.class.getResource("/images/TransportHub" + getName() + "ImageSmall.png")));

			}
		});
	}
}
