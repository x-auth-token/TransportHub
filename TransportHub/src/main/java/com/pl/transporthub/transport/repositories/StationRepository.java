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
import com.pl.transporthub.transport.Bus;
import com.pl.transporthub.transport.Line;
import com.pl.transporthub.transport.Station;
import com.pl.transporthub.util.db.DatabaseController;

public class StationRepository implements GenericRepository<Station> {

	private DatabaseController dbController;
	private ResultSet rs;
	
	public StationRepository() {
		dbController = new DatabaseController();
		dbController.start();
	}
	@Override
	public void add(Station t) {
		

	}

	@Override
	public void remove(Station t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Station getByID(Integer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Station get(Station t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Station> getAll() {
		ArrayList<Station> stations = new ArrayList<Station>();

		try {
			ResultSet rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT * FROM buses");

			if (rs != null) {

				while (rs.next()) {
					Station station = new Station();

					station.setStationID(rs.getInt("stationID"));
					station.setStationCoordinates(
							new Coordinate(rs.getFloat("stationCoordinateX"), rs.getFloat("stationCoordinateY")));
					station.setStationAddress(rs.getString("stationAddress"));
					station.setLines(rs.getString("lineIDs"));
					station.setStationName(rs.getString("stationName"));
					station.setStationState(station.stringToStationState(rs.getString("StationState")));

					stations.add(station);
				}
				return stations;

			}
			return stations;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public ResultSet getStationsResultSet() throws SQLException {

		rs = dbController.getSqliteConnection().getStatement().executeQuery(
				"SELECT stationName as 'Station Name', stationAddress as 'Station Address', lineIDs as 'Lines', stationState as 'Station Status' FROM stations");

		return rs;
	}

	@Override
	public Station save(Station t) {
		// TODO Auto-generated method stub
		return null;
	}

}
