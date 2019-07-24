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
package com.pl.transporthub.transport.repositories;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pl.transporthub.shared.classes.Coordinate;
import com.pl.transporthub.shared.interfaces.GenericRepository;
import com.pl.transporthub.transport.Route;
import com.pl.transporthub.transport.Station;
import com.pl.transporthub.util.db.DatabaseController;

public class RouteRepository implements GenericRepository<Route> {
	
	private DatabaseController dbController;


	public RouteRepository() {
		dbController = new DatabaseController();
		dbController.start();
	}
	@Override
	public void add(Route t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Route t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Route getByID(Integer t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	@Override
	public Route get(Route t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Route> getAll() {
		ArrayList<Route> routes = new ArrayList<Route>();

		try {
			ResultSet rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT * FROM buses");

			if (rs != null) {

				while (rs.next()) {
					Route route = new Route();

					/*
					 * route.set(rs.getInt("lineID")); route.setStationCoordinates( new
					 * Coordinate(rs.getFloat("stationCoordinateX"),
					 * rs.getFloat("stationCoordinateY")));
					 * route.setStationAddress(rs.getString("stationAddress"));
					 * route.setLines(rs.getString("lineIDs"));
					 * route.setStationName(rs.getString("stationName"));
					 * route.setStationState(route.stringToStationState(rs.getString("StationState")
					 * ));
					 */

					routes.add(route);
				}
				return routes;

			}
			return routes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public Route save(Route t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
