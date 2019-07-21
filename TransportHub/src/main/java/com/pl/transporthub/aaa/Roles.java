package com.pl.transporthub.aaa;

public class Roles {
	public enum Role {
		PASSENGER,
		DRIVER,
		PTM,
		ADMIN;

		public static Role toRole(String role) {
			if (role.equalsIgnoreCase("ADMIN")) {
				return Role.ADMIN;
			}
			else if (role.equalsIgnoreCase("DRIVER")) {
				return Role.DRIVER;
			} else if (role.equalsIgnoreCase("PTM")) {
				return Role.PTM;
			} else if (role.equalsIgnoreCase("PASSENGER")) {
				return Role.PASSENGER;
			}
			
			return null;
		}
	}
	
	
}
