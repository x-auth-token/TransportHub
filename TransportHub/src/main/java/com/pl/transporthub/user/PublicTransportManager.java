package com.pl.transporthub.user;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.pl.transporthub.aaa.Permissions;

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
	
	public PublicTransportManager(String un, char[] pass, LocalDate expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);
		// TODO Auto-generated constructor stub
	}
	
}
