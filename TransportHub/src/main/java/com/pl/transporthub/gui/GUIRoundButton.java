/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
		// setTextA
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
