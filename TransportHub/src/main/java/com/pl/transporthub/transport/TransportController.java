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
package com.pl.transporthub.transport;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import com.pl.transporthub.transport.repositories.BusRepository;
import com.pl.transporthub.transport.repositories.StationRepository;
import com.pl.transporthub.util.db.DatabaseController;

public class TransportController {
	
	private static BusRepository br;
	private static Line line;
	private static Station st;
	private static Route route;
	private static DatabaseController dbController = new DatabaseController();
	private static ResultSet rs;
	private static StationRepository sr;
	
	public TransportController() {
		start();
	}
	
	public void start() {
		br = new BusRepository();
		line = new Line();
		st = new Station();
		route = new Route();
		dbController.start();
	}
	
	public static BusRepository getBusRepository() {
		return br;
	}
	
	public static StationRepository getStationRepository() {
		return sr;
	}
	
	public static DefaultTableModel generateBusTableModel() throws SQLException {
	
			rs = br.getBusesResultSet();
	

		return DatabaseController.buildTableModel(rs);
	}
	
	public static DefaultTableModel generateStationTableModel() throws SQLException {
		
		rs = sr.getStationsResultSet();


	return DatabaseController.buildTableModel(rs);
}
}
