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
package com.pl.transporthub.transporthub.views;

import javax.swing.JButton;

import com.pl.transporthub.transporthub.baseclasses.GUIBaseApplicationView;
import com.pl.transporthub.transporthub.buttons.GUIRoundButton;
import com.pl.transporthub.transporthub.buttons.GUIRoundButtonFactory;

public class GUIAuthenticatedUsersView extends GUIBaseApplicationView {

	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private GUIRoundButton btnLogout;
	

	public GUIAuthenticatedUsersView() {
		super();

	}

	@Override
	public void initComponents() {
		btnLogout = GUIRoundButtonFactory.getRoundButton("Logout", "LogoutButton");
		//testBTN = new JButton("TEST");
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
