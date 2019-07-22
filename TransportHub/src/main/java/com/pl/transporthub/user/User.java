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
package com.pl.transporthub.user;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pl.transporthub.aaa.Roles.Role;




public interface User {

	
	
	/*
	 * private Integer userID; private AtomicInteger uniqueID = new AtomicInteger();
	 * 
	 * 
	 * private String username; private String password;
	 * 
	 * private LocalDate expirationDate; private int enabled;
	 * 
	 * private String address;
	 * 
	 * private String passportID;
	 * 
	 * private String email;
	 * 
	 * private String mobileNumber;
	 * 
	 * private Role role;
	 * 
	 * private boolean authenticated;
	 */
	
	
	
	
	

	/*
	 * public User() { generateUserID(); setUsername(null); setPassword(null);
	 * setExpirationDate(null); }
	 * 
	 * public User(String un, char[] pass, boolean adminValue) {
	 * 
	 * generateUserID(); setUsername(un); setPassword(pass); setAdmin(adminValue); }
	 */
	
	/*
	 * public User() {
	 * 
	 * }
	 * 
	 * public User(String un, String pass) {
	 * 
	 * generateUserID(); setUsername(un); setPassword(pass);
	 * setExpirationDate(null);
	 * 
	 * }
	 */
	
	/*
	 * public User(String un, String pass, LocalDate expirationDate, boolean
	 * adminValue) {
	 * 
	 * generateUserID(); setUsername(un); setPassword(pass);
	 * setExpirationDate(expirationDate); //setAdmin(adminValue); }
	 */

	public String getUsername(); //{
		//return username;
	//}

	public void setUsername(String username); //{
		//this.username = username;
	//}

	public String getPassword(); //{
		//return password;
	//}

	public void setPassword(String password);// {
		//this.password = password;
	//}
	
	public LocalDate getExpirationDate() ;//{
		//return expirationDate;
	//}

	public void setExpirationDate(LocalDate expirationDate) ;//{
		//this.expirationDate = expirationDate;
	//}
	
	public Integer getUserID();// {
		//return userID;
	//}

	public void generateUserID(); //{
		//this.userID = uniqueID.incrementAndGet();
	//}
	
	public int isEnabled(); //{
		//return this.enabled;
	//}
	
	/*
	 * public void setEnabled(boolean enabled) { this.enabled = enabled; }
	 */
	/*
	 * public void setDisabled() { this.enabled = false; }
	 */
	
	/*
	 * public boolean isAdmin() { return this.isadmin; }
	 */
	
	/*
	 * public void setAdmin(boolean adminValue) { this.isadmin = adminValue; }
	 */

	/**
	 * @return the isadmin
	 */
	/*
	 * public boolean isIsadmin() { return isadmin; }
	 */

	/**
	 * @param isadmin the isadmin to set
	 */
	/*
	 * public void setIsadmin(boolean isadmin) { this.isadmin = isadmin; }
	 */

	/**
	 * @return the email
	 */
	public String getEmail();// {
		//return email;
	//}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email);// {
		//this.email = email;
	//}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID);// {
		//this.userID = userID;
	//}

	/**
	 * @param i the enabled to set
	 */
	public void setEnabled(int i);// {
		//this.enabled = i;
	//}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber();// {
		//return mobileNumber;
	//}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) ;//{
		//this.mobileNumber = mobileNumber;
	//}

	/**
	 * @return the role
	 */
	public Role getRole();// {
		//return role;
	//}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) ;//{
		//this.role = role;
	//}

	/**
	 * @return the authenticated
	 */
	public boolean isAuthenticated();// {
		//return authenticated;
	//}

	/**
	 * @param authenticated the authenticated to set
	 */
	public void setAuthenticated(boolean authenticated) ;//{
		//this.authenticated = authenticated;
	//}

	public String getAddress();// {
		//return address;
	//}

	public void setAddress(String address);// {
		//this.address = address;
	//}

	public String getPassportID() ;//{
		//return passportID;
	//}

	public void setPassportID(String passportID) ;//{
		//this.passportID = passportID;
	//}
	
	public void setFirstName(String firstName);
	
	public String getFirstName();
	public String getLastName();
	
	public void setLastName(String lastName);
	

	
	
	
}
