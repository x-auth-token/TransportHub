/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.pl.transporthub.transporthub.buttons;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.pl.transporthub.transporthub.views.GUIMainWindowView;

public abstract class GUIRoundButton extends JLabel {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3981582768570030965L;

	/**
	 * @return 
	 * 
	 */
	/*
	 * private static final long serialVersionUID = -1108283401029565569L;
	 * 
	 * public GUIRoundButton(String btnName, String btnIconName) {
	 * this.setName(btnName); this.setIcon(new
	 * ImageIcon(getClass().getResource(btnIconName)));
	 * this.setHorizontalAlignment(SwingConstants.CENTER);
	 * changeLableIconOnMouseHover(); }
	 * 
	 * public GUIRoundButton(String btnName, String btnIconName, String btntext) {
	 * 
	 * this(btnName, btnIconName); setText(btntext);
	 * setVerticalTextPosition(BOTTOM); setHorizontalTextPosition(CENTER);
	 * setForeground(Color.WHITE); // setTextA }
	 */
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
						GUIMainWindowView.class.getResource("/images/TransportHub" + getName() + "ImageBig.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setIcon(new ImageIcon(
						GUIMainWindowView.class.getResource("/images/TransportHub" + getName() + "ImageSmall.png")));

			}
		});
		
		
			
		
	
	}
	
	public void showButton() {
		this.setVisible(true);
	}
	
	public void hideButton() {
		this.setVisible(false);
	}
}
