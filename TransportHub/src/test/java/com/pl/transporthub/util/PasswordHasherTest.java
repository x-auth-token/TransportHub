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
