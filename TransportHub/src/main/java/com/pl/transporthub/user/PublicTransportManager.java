package com.pl.transporthub.user;

import java.time.LocalDate;

public class PublicTransportManager extends AuthenticatedUser {

	/*
	 * public PublicTransportManager() { super(); // TODO Auto-generated constructor
	 * stub }
	 * 
	 * 
	 * 
	 * public PublicTransportManager(String un, char[] pass, boolean adminValue) {
	 * super(un, pass, adminValue); // TODO Auto-generated constructor stub }
	 */
	
	public PublicTransportManager(String un, String pass, LocalDate expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);
		// TODO Auto-generated constructor stub
	}
	
}
