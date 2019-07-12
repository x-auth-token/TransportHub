package com.pl.transporthub.user;

import java.util.Date;
import java.util.List;

import com.pl.transporthub.aaa.Permission;

public class Passenger extends AuthenticatedUser {

	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String un, char[] pass, List<Permission> permissions, Date expirationDate) {
		super(un, pass, permissions, expirationDate);
		// TODO Auto-generated constructor stub
	}

	public Passenger(String un, char[] pass, List<Permission> permissions) {
		super(un, pass, permissions);
		// TODO Auto-generated constructor stub
	}


	
}
