package com.pl.transporthub.transporthub;

public class GUIRoundButtonFactory {
	public static GUIRoundButton getRoundButton(String bType, String bName) {
		if ("Bus".equalsIgnoreCase(bType)) { return new GUIRoundBusButton(bName); }
		else if ("Station".equalsIgnoreCase(bType)) { return new GUIRoundStationButton(bName); }
		else if ("Route".equalsIgnoreCase(bType)) { return new GUIRoundRouteButton(bName); }
		else if ("Map".equalsIgnoreCase(bType)) { return new GUIRoundMapButton(bName); }
		else if ("Login".equalsIgnoreCase(bType)) { return new GUIRoundLoginButton(bName); }
		return null;
	}
}
