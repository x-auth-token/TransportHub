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
import java.time.ZoneId;
import java.util.ArrayList;

import org.eclipse.persistence.jpa.jpql.parser.TrimExpression.Specification;

import com.pl.transporthub.aaa.Roles.Role;
import com.pl.transporthub.shared.interfaces.GenericRepository;
import com.pl.transporthub.transport.Bus;
import com.pl.transporthub.transport.Line;
import com.pl.transporthub.user.User;
import com.pl.transporthub.user.UserFactory;
import com.pl.transporthub.util.db.DatabaseController;

public class BusRepository implements GenericRepository<Bus>{
	private DatabaseController dbController;
	private ResultSet rs;
	
	public BusRepository() {
		dbController = new DatabaseController();
		dbController.start();
	}
	
	@Override
	public void add(Bus t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Bus t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bus getByID(Integer b) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public Bus get(Bus t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Bus> getAll() {
		ArrayList<Bus> buses = new ArrayList<Bus>();
		
		try {
			ResultSet rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT * FROM buses");
			
			if (rs != null ) {
				
				
				while(rs.next())  {
					Bus bus = new Bus();
					
					bus.setAssignedDriverID(rs.getInt("assignedDriverID"));
					bus.setAssignedLine(new Line(rs.getInt("assignedLine")));
					bus.setBusCondition(bus.intToEnum(rs.getInt("busCondition")));
					bus.setBusID(rs.getInt("busID"));
					bus.setBusRegPlate(rs.getString("busRegPlate"));
					
					buses.add(bus);
					}
				return buses;
					
			}
			return buses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Iterable<Bus> find(Specification spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bus save(Bus t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet getBusesResultSet() throws SQLException {
	
	
			rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT busRegPlate as 'Bus Plate Number',assignedLine as 'Line Number',busCondition as 'Bus Condition' FROM buses");

		
		return rs;
	}
	
}
