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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.pl.transporthub.transporthub.baseclasses.GUIBaseApplicationView;
import com.pl.transporthub.transporthub.baseclasses.GUICustomCloseApplication;
import com.pl.transporthub.transporthub.views.GUIAdminView;
import com.pl.transporthub.user.User;

public class GUIAdminController {

	private GUIAdminView adminView;
	private User adminUser;
	private GUICustomCloseApplication closeApplication;

	public GUIAdminController(User user) {
		adminUser = user;
		initAppView();
		setActionListeners();
		setMouseListeners();
		
	}

	public void initAppView() {
		adminView = new GUIAdminView();
	}

	public void setActionListeners() {
		
		  closeApplication = new GUICustomCloseApplication();
		  
		  adminView.getContentPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW
		  ).put(KeyStroke.getKeyStroke("shift ctrl pressed E"),"Exit");
		  adminView.getContentPane().getActionMap().put("Exit", closeApplication);
		  
		  
		  adminView.getBtnManageUsers().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					;
				}
			});
		  
		  adminView.getBtnLogs().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					;
				}
			});
		  
		  adminView.getBtnCloseProgram().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					adminUser.setAuthenticated(false);
					adminView.hideAppWindow();
					System.exit(0);
				}
			});
		  
		 

	}

	public void setMouseListeners() {
		adminView.getBtnLogout().addMouseListener(new MouseListener() {

			private GUIMainWindowController mainWindowController;

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				adminUser.setAuthenticated(false);
				adminView.hideAppWindow();
				adminView.closeAppWindow();
				mainWindowController = new GUIMainWindowController();
				mainWindowController.start();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	/**
	 * @return the mainWindowView
	 */

	public void start() {
		adminView.showAppWindow();
	}

}
