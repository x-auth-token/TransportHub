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
package com.pl.transporthub.aaa.baseclasses;

import static com.pl.transporthub.shared.classes.Constants.*;

public abstract class Validators {

	public static boolean validateOnlyLettersUsed(String s) {

		for (int i = 0; i < s.length(); i++) {

			if (!Character.isLetter(s.charAt(i))) {

				return false;
			}
		}
		return true;
	}

	public static boolean isCorrectIDFormat(String id) {

		for (int i = 0; i < id.length(); i++) {

			if (!Character.isDigit(id.charAt(i)) || id.length() != ID_LENGTH) {

				return false;
			}
		}
		return true;
	}

	public static boolean isCorrectPhoneNumberFormat(String pn) {

		if (pn.length() < PHONE_LENGTH_MIN || pn.length() > PHONE_LENGTH_MAX)
			return false;

		for (int i = 0; i < pn.length(); i++) {
			if (i == 0 && pn.charAt(0) == '+')
				i++;
			if (!Character.isDigit(pn.charAt(i)))
				return false;
		}

		return true;
	}

	public static boolean validateOnlyNumbersUsed(String n) {
		for (int i = 0; i < n.length(); i++)
			if (!Character.isDigit(n.charAt(i)))
				return false;
		return true;

	}

}
