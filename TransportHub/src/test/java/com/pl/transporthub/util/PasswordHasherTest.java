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
package com.pl.transporthub.util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.DecoderException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.pl.transporthub.aaa.baseclasses.PasswordHasher;

public class PasswordHasherTest {

	public static final char[] pass = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
	public static final char[] pass2 = { 'a', 'd', 'm', 'i', 'n' };
	public static final char[] pass3 = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '3' };

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testGenerateHashedPassword() {

		try {
			String sp = PasswordHasher.generateHashedPassword(pass);
			String sp2 = PasswordHasher.generateHashedPassword(pass2);
			// Assert.assertNotEquals(sp, sp2);
			System.out.println(sp2.toString());
			assertNotEquals(sp2, sp);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testValidateHashedPassword() {

		try {
			final String saltedPass = PasswordHasher.generateHashedPassword(pass);
			//System.out.println(saltedPass);
			assertTrue(PasswordHasher.validateHashedPassword(pass, saltedPass));
		} catch (DecoderException | InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
