/*******************************************************************************
 * Copyright (C) 2019 Pavel Mayzenberg, Leon Peper, Oded Levin
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.pl.transporthub.user;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pl.transporthub.aaa.Roles.Role;




public abstract class User {

	
	
	private Integer userID;
	private AtomicInteger uniqueID = new AtomicInteger();
	

	private String username;
	private char[] password;
	
	private LocalDate expirationDate;
	private boolean enabled;
	
	private boolean isadmin;
	
	private String email;
	
	private String mobileNumber;
	
	private Role role;
	
	private boolean authenticated;
	
	
	

	/*
	 * public User() { generateUserID(); setUsername(null); setPassword(null);
	 * setExpirationDate(null); }
	 * 
	 * public User(String un, char[] pass, boolean adminValue) {
	 * 
	 * generateUserID(); setUsername(un); setPassword(pass); setAdmin(adminValue); }
	 */
	
	public User() {
		
	}
	public User(String un, char[] pass, LocalDate expirationDate, boolean adminValue) {
		
		generateUserID();
		setUsername(un);
		setPassword(pass);
		setExpirationDate(expirationDate);
		setAdmin(adminValue);
	}

	protected String getUsername() {
		return username;
	}

	protected void setUsername(String username) {
		this.username = username;
	}

	protected char[] getPassword() {
		return password;
	}

	protected void setPassword(char[] password) {
		this.password = password;
	}
	
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public Integer getUserID() {
		return userID;
	}

	public void generateUserID() {
		this.userID = uniqueID.incrementAndGet();
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled() {
		this.enabled = true;
	}
	
	public void setDisabled() {
		this.enabled = false;
	}
	
	public boolean isAdmin() {
		return this.isadmin;
	}
	
	public void setAdmin(boolean adminValue) {
		this.isadmin = adminValue;
	}

	/**
	 * @return the isadmin
	 */
	public boolean isIsadmin() {
		return isadmin;
	}

	/**
	 * @param isadmin the isadmin to set
	 */
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/**
	 * @param authenticated the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	

	
	
	
}
