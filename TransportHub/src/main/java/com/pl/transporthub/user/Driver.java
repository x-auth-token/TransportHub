package com.pl.transporthub.user;

import java.time.LocalDate;

import com.pl.transporthub.aaa.Roles.Role;

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
	
	
	
	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(String un, String pass) {
		super(un, pass);
		setRole(Role.DRIVER);
	}

	public Driver(String un, String pass, LocalDate expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);
		setRole(Role.DRIVER);
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	
	
}
