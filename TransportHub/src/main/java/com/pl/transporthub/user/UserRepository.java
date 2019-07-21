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
package com.pl.transporthub.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import org.eclipse.persistence.jpa.jpql.parser.TrimExpression.Specification;

import com.pl.transporthub.shared.interfaces.GenericRepository;
import com.pl.transporthub.util.db.SQLiteJDBC;

public class UserRepository implements GenericRepository<User>{
	
	private SQLiteJDBC sqliteConneciton;
	private final String dbFolderName = "db";
	private final String dbName = "Users"; 
	
	public UserRepository() {
		
		try {
			sqliteConneciton = new SQLiteJDBC(dbFolderName, dbName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void add(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(User t) {
		try {
			ResultSet rs = sqliteConneciton.getStatement().executeQuery("SELECT * FROM Users WHERE username = '" + t.getUsername() + "'");
			
			if (rs != null ) {
				while(rs.next())  {
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
					
					}
					
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User save(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> find(Specification spec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User getUserByName(String username) {
		try {
		ResultSet rs = sqliteConneciton.getStatement().executeQuery("SELECT * FROM Users WHERE username = '" + username + "'");
		
		if (rs != null ) {
			while(rs.next())  {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				
				}
				
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}

	public String getUserRole(String username) {
		try {
			ResultSet rs = sqliteConneciton.getStatement().executeQuery("SELECT role FROM Users WHERE username = '" + username + "'");
		
			
			if (rs != null ) {
				while (rs.next()) {
					System.out.println(rs.getString("role"));
				}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getUserPassword(String username) {
		try {
			ResultSet rs = sqliteConneciton.getStatement().executeQuery("SELECT * FROM Users WHERE username = '" + username + "'");
		
			
			if (rs != null ) {
				while (rs.next()) {
					System.out.println(rs.getString("password"));
				}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
}
