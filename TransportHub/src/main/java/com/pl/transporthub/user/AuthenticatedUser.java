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
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.pl.transporthub.aaa.Permissions.Permission;
import com.pl.transporthub.aaa.Roles.Role;

public class AuthenticatedUser implements User {
	
	private Integer userID;
	private AtomicInteger uniqueID = new AtomicInteger();
	

	private String username;
	private String password;
	
	private LocalDate expirationDate;
	private int enabled;
	
	private String address;
	
	private String passportID;
	
	private String email;
	
	private String mobileNumber;
	
	private Role role;
	
	private boolean authenticated;
	
	private String firstName;
	private String lastName;
	
	public AuthenticatedUser(String un, String pass) {
		//super(un, pass);
		generateUserID();
		setUsername(un);
		setPassword(pass);
		setExpirationDate(null);
		setEnabled(1);
	}

	private Set<Permission> permissions;

	/*
	 * public AuthenticatedUser() { super(); }
	 * 
	 * public AuthenticatedUser(String un, char[] pass, boolean adminValue) {
	 * super(un, pass, adminValue);
	 * 
	 * }
	 */
	public AuthenticatedUser() {
		//super();
	}
	
	public AuthenticatedUser(String un, String pass, LocalDate expirationDate, boolean adminValue) {
		//super(un, pass, expirationDate, adminValue);
		generateUserID();
		setUsername(un);
		setPassword(pass);
		setExpirationDate(expirationDate);

	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void addPermission(Permission permission) {
		this.permissions.add(permission);
	}
	
	public boolean hasPermission(Permission permission) {
		return this.permissions.contains(permission);
	}
	
	public void removePermission(Permission permission) {
		this.permissions.remove(permission);
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public AtomicInteger getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(AtomicInteger uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassportID() {
		return passportID;
	}

	public void setPassportID(String passportID) {
		this.passportID = passportID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	@Override
	public void generateUserID() {
		//this.userID = uniqueID.incrementAndGet();
		UserRepository ur = new UserRepository();
		this.userID = ur.getMaxUserID() + 1;
	}

	@Override
	public int isEnabled() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}

	@Override
	public String getFirstName() {
		
		return firstName;
	}

	@Override
	public String getLastName() {
		
		return lastName;
	}
	
	
	
	
}
