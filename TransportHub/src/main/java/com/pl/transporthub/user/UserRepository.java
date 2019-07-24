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
package com.pl.transporthub.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;



import com.pl.transporthub.aaa.Roles.Role;
import com.pl.transporthub.shared.interfaces.GenericRepository;
import com.pl.transporthub.util.db.DatabaseController;
import com.pl.transporthub.util.db.SQLiteJDBC;
import com.sun.xml.internal.ws.Closeable;

public class UserRepository implements GenericRepository<User>{
	
	/*
	 * private SQLiteJDBC sqliteConneciton; private String dbFolderName; private
	 * String dbName;
	 */
	private DatabaseController dbController;
	private PreparedStatement ps;
	private ResultSet rs;
	private User user;
	
	/*public UserRepository(String dbFolderName, String dbName) {
		
		this.setDbFolderName(dbFolderName);
		
		this.setDbName(dbName);
		try {
			sqliteConneciton = new SQLiteJDBC(dbFolderName, dbName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
public UserRepository() {
		
		dbController = new DatabaseController();
		dbController.start();

	}

	@SuppressWarnings("static-access")
	@Override
	public void add(User user) {
		

		
		if (getUserByName(user.getUsername()) == null ) {
			final String sql = "INSERT INTO users (userID, username, password, expirationDate, enabled, firstName, lastName, passportID, address, email, mobileNumber, role) "
						+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			//Instant instant = user.getExpirationDate().atStartOfDay(ZoneId.systemDefault()).toInstant();
			//Time time = (Time) Time.from(instant);
			try {
				
				dbController.getSqliteConnection().getConnection().setAutoCommit(false);
				ps = dbController.preparedStatement(sql);
			
				
				  ps.setInt(1, user.getUserID()); 
				  ps.setString(2, user.getUsername());
				  ps.setString(3, user.getPassword()); 
				  ps.setTime(4, null); 
				  ps.setInt(5, user.isEnabled()); 
				  ps.setString(6, user.getFirstName()); 
				  ps.setString(7, user.getLastName());
				  ps.setString(8, user.getPassportID()); 
				  ps.setString(9, user.getAddress()); 
				  ps.setString(10, user.getEmail()); 
				  ps.setString(11, user.getMobileNumber()); 
				  ps.setString(12, user.getRole().toString());
				 
				 
				
				  ps.executeUpdate();
				  
				  dbController.getConnection().commit();
				  
				System.out.println(ps.getUpdateCount());
		
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void remove(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(User t) {
		try {
			rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT * FROM Users WHERE username = '" + t.getUsername() + "'");
			
			if (rs != null ) {
				while(rs.next())  {
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
					
					}
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
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
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT * FROM users");
			
			if (rs != null ) {
				
				
					while(rs.next())  {
						user = UserFactory.getUser(getUserRole(rs.getString("role")), rs.getString("username"), rs.getString("password"));
						//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
						user.setUserID(rs.getInt("userID"));
						user.setExpirationDate(rs.getTime("expirationDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
						user.setRole(Role.toRole(rs.getString("role")));
						user.setEmail(rs.getString("email"));
						user.setMobileNumber(rs.getString("mobileNumber"));
						user.setEnabled(rs.getInt("enabled"));
						user.setAuthenticated(false);
						user.setAddress(rs.getString("address"));
						
						users.add(user);
						
						}
					
						
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				return users;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}



	@Override
	public User getByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User getUserByName(String username) {
		
		
		try {
			rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT * FROM Users WHERE username = '" + username + "'");
		
		if (rs != null ) {
			
		user = UserFactory.getUser(getUserRole(username), username, getUserPassword(username));
			while(rs.next())  {
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				user.setUserID(rs.getInt("userID"));
				user.setExpirationDate(rs.getTime("expirationDate").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				user.setRole(Role.toRole(rs.getString("role")));
				user.setEmail(rs.getString("email"));
				user.setMobileNumber(rs.getString("mobileNumber"));
				user.setEnabled(rs.getInt("enabled"));
				user.setAuthenticated(false);
				user.setAddress(rs.getString("address"));
				
				
				}
				
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	return null;
	}

	public String getUserRole(String username) {
		try {
			rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT role FROM Users WHERE username = '" + username + "'");
		
			
			if (rs != null ) {
				while (rs.next()) {
					return rs.getString("role");
				}
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return null;
	}
	
	public String getUserPassword(String username) {
		try {
			rs = dbController.getSqliteConnection().getStatement().executeQuery("SELECT * FROM Users WHERE username = '" + username + "'");
		
			
			if (rs != null ) {
				while (rs.next()) {
					return rs.getString("password");
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return null;
	
	}
	
	public int getMaxUserID() {
		
		String sql = "SELECT MAX(userID) as maxid FROM users";
		
		int id = 0;
		try {
			
			rs = dbController.getSqliteConnection().executeQuery(sql);
			if (rs.next()) 
				id = rs.getInt("maxid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}
	
}
