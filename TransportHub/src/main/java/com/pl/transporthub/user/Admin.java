package com.pl.transporthub.user;

import java.time.LocalDate;

public class Admin extends AuthenticatedUser {

	/*
	 * public Admin() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * public Admin(String un, char[] pass, Date expirationDate, boolean adminValue)
	 * { super(un, pass, expirationDate, adminValue); // TODO Auto-generated
	 * constructor stub }
	 * 
	 * public Admin(String un, char[] pass, boolean adminValue) { super(un, pass,
	 * adminValue); // TODO Auto-generated constructor stub }
	 */
	public Admin() {}
	public Admin(String un, String pass, LocalDate expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);
		// TODO Auto-generated constructor stub
	}

	
	
}
