package com.pl.transporthub.user;

import java.util.Date;
import java.util.List;

import com.pl.transporthub.aaa.Permission;

public class Passenger extends AuthenticatedUser {

	/*
	 * public Passenger() { super(); // TODO Auto-generated constructor stub }
	 * 
	 * 
	 * 
	 * public Passenger(String un, char[] pass, boolean adminValue) { super(un,
	 * pass, adminValue); // TODO Auto-generated constructor stub }
	 */
	private String mobileNumber;
	private String passportID;
	public Passenger(String un, char[] pass, Date expirationDate, boolean adminValue) {
		super(un, pass, expirationDate, adminValue);
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
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

	
	
}
