package com.pl.transporthub.user;

import java.time.LocalDate;

public class Driver extends AuthenticatedUser {

	/*
	 * public Driver() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * 
	 * 
	 * public Driver(String un, char[] pass, boolean adminValue) { super(un, pass,
	 * adminValue); // TODO Auto-generated constructor stub }
	 */
	private int driverID;
	
	public Driver(String un, String pass, LocalDate expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);
		// TODO Auto-generated constructor stub
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	
	
}
