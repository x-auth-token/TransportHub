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
package com.pl.transporthub.transporthub.buttons;

public class GUIRoundButtonFactory {
	public static GUIRoundButton getRoundButton(String bType, String bName) {
		if ("Bus".equalsIgnoreCase(bType)) { return new GUIRoundBusButton(bName); }
		else if ("Station".equalsIgnoreCase(bType)) { return new GUIRoundStationButton(bName); }
		else if ("Route".equalsIgnoreCase(bType)) { return new GUIRoundRouteButton(bName); }
		else if ("Map".equalsIgnoreCase(bType)) { return new GUIRoundMapButton(bName); }
		else if ("Login".equalsIgnoreCase(bType)) { return new GUIRoundLoginButton(bName); }
		else if ("Logout".equalsIgnoreCase(bType)) { return new GUIRoundLogoutButton(bName); }
		
		
		return null;
	}
}
