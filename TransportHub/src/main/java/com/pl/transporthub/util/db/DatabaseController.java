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
package com.pl.transporthub.util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;



public class DatabaseController {
	private final String dbFolderName = "DB";
	private final String dbName = "TransportHub";
	
	private SQLiteJDBC sqliteConnection;
	
	public DatabaseController() {}
	
	/*
	 * public DatabaseController(String dbFolderName, String dbName) {
	 * this.dbFolderName = dbFolderName; this.dbName = dbName;
	 * 
	 * }
	 */

	public void start() {
		try {
			sqliteConnection = new SQLiteJDBC(dbFolderName, dbName);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return the dbFolderName
	 */
	public String getDbFolderName() {
		return dbFolderName;
	}

	/**
	 * @param dbFolderName the dbFolderName to set
	 */
	/*
	 * public void setDbFolderName(String dbFolderName) { this.dbFolderName =
	 * dbFolderName; }
	 */

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	/*
	 * public void setDbName(String dbName) { this.dbName = dbName; }
	 */

	/**
	 * @return the sqliteConnection
	 */
	public SQLiteJDBC getSqliteConnection() {
		return sqliteConnection;
	}

	/**
	 * @param sqliteConnection the sqliteConnection to set
	 */
	public void setSqliteConnection(SQLiteJDBC sqliteConnection) {
		this.sqliteConnection = sqliteConnection;
	}
	
	public void first_run() {
		try {
			sqliteConnection.parseSqlFromScript();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection  getConnection() {
		
		return sqliteConnection.getConnection();
	}
	
	@SuppressWarnings("static-access")
	public PreparedStatement preparedStatement(String sql) throws SQLException {
		return sqliteConnection.getConnection().prepareStatement(sql);
	}
	
	public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
	    rs.close();
	    return new DefaultTableModel(data, columnNames);

	}
	
}
