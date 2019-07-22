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
package com.pl.transporthub.transporthub.controllers;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Set;

import com.pl.transporthub.transporthub.baseclasses.GUIAbstractApplicationWindowController;
import com.pl.transporthub.transporthub.views.GUIAdminView;
import com.pl.transporthub.transporthub.views.GUIAuthenticatedUsersView;
import com.pl.transporthub.transporthub.views.GUIMainWindowView;
import com.pl.transporthub.user.User;

public class GUIAuthenticatedUsersController extends GUIAbstractApplicationWindowController {

	private GUIMainWindowController mainWindowController;
	private GUIAuthenticatedUsersView authUsersView;
	private GUIAdminController adminController;
	private User user;


	public GUIAuthenticatedUsersController(User user) {

		this.user = user;
	}

	@Override
	public void setMouseListeners() { 

		super.setMouseListeners();

		authUsersView.getBtnLogout().addMouseListener(new MouseListener() {

			@Override public void mouseReleased(MouseEvent e) {
			}
			@Override public void mousePressed(MouseEvent e) {
				user.setAuthenticated(false);
				authUsersView.hideAppWindow();
				authUsersView.closeAppWindow();
				mainWindowController = new GUIMainWindowController();
				mainWindowController.start();
			}

			@Override public void mouseExited(MouseEvent e) { 
			}

			@Override public void mouseEntered(MouseEvent e) { 

			}

			@Override public void mouseClicked(MouseEvent e) { 
			} 

		});



	}



	

	@Override 
	public void start() {
		
		generateViewByRole(user);
	}

	public void generateViewByRole(User user) {

		switch (user.getRole()) {
		case PASSENGER:
			authUsersView = new GUIAuthenticatedUsersView();
			setMouseListeners();
			authUsersView.showAppWindow();
			break;


		case DRIVER:
			;
		case PTM:
			;
		case ADMIN:
			adminController = new GUIAdminController(user);
			adminController.start();
			break;
		default:
			break;
		}
	}

	public void whoHasFocus() {
		System.out.println("the owner is:" +  authUsersView.getAppFrame().getFocusOwner());
	}
}



