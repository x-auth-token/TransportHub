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
		//EventQueue.invokeLater(new Runnable() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					startDB();
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
	
	public static void startDB() throws SQLException {
		DatabaseController dbController = new DatabaseController();
		dbController.start();
	}
	

}
