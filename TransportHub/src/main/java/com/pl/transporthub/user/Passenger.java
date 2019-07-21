package com.pl.transporthub.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pl.transporthub.aaa.Roles.Role;


public class Passenger extends AuthenticatedUser {

	/*
	 * public Passenger() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * 
	 * 
	 * public Passenger(String un, String pass, boolean adminValue) { super(un,
	 * pass, adminValue); // TODO Auto-generated constructor stub }
	 */
	
	private String passportID;
	
	private boolean vip;
	
	public Passenger() {
		super();
		
	}
	
	
	
	public Passenger(String un, String pass) {
		super(un, pass);
		setRole(Role.PASSENGER);
	}



	public Passenger(String un, String pass, LocalDate expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);
		setRole(Role.PASSENGER);
		
	}
	/**
	 * @return the mobileNumber
	 */

	/**
	 * @return the passportID
	 */
	public String getPassportID() {
		return passportID;
	}
	/**
	 * @param passportID the passportID to set
	 */
	public void setPassportID(String passportID) {
		this.passportID = passportID;
	}

	/**
	 * @return the vip
	 */
	public boolean isVip() {
		return vip;
	}

	/**
	 * @param vip the vip to set
	 */
	public void setVip(boolean vip) {
		this.vip = vip;
	}

	
	
}
