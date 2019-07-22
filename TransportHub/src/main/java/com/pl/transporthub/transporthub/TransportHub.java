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
package com.pl.transporthub.transporthub;

import java.sql.SQLException;

//import java.awt.EventQueue;
import javax.swing.SwingUtilities;

import com.pl.transporthub.transporthub.controllers.GUIMainWindowController;
import com.pl.transporthub.util.db.DatabaseController;

/**
 * 	This is a main executable of the TransportHub project
 * 
 * @author Pavel Mayzenberg, Leon Peper, Oded Levin
 * @version 1.0 
 * 
 * 
 */
public class TransportHub {

	public static void main(String[] args) {
		boolean firstRun = true;
		//EventQueue.invokeLater(new Runnable() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					startDB(firstRun);
					createAndShowGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	
	public static void createAndShowGUI() throws Exception {
		
		
		  GUIMainWindowController mainWindowController = new GUIMainWindowController();
		  mainWindowController.start();

	}
	
	public static void startDB(boolean isFirstrun) throws SQLException {
		DatabaseController dbController = new DatabaseController();
		dbController.start();
		
		if (isFirstrun) {
			dbController.first_run();
			isFirstrun = false;
		}
	}
	

}
