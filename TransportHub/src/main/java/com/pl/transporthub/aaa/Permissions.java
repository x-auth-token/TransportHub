package com.pl.transporthub.aaa;

public abstract class Permissions {
	
	private Permissions() {};
	
	public enum Permission {
	ANONYMOUS,
	AUTHPASSANGER,
	DRIVER,
	PTM,
	ADMIN
	}

	public static Permission toPermission(String permission) {
		
		switch (permission.toUpperCase()) {
		case "ANONYMOUS":
			return Permission.ANONYMOUS;
		case "AUTHPASSANGER":
			return Permission.AUTHPASSANGER;
		case "DRIVER":
			return Permission.DRIVER;
		case "PTM":
			return Permission.PTM;
		case "ADMIN":
			return Permission.ADMIN;
		default:
			return null;
		}
	
	}
}