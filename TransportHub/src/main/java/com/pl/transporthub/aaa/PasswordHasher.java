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
package com.pl.transporthub.aaa;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class PasswordHasher {

	private static final int KEY_LENGTH = 512;
	private static final String ALGO_NAME = "PBKDF2WithHmacSHA512";
	private static final int ITERATIONS = 1000;

	private PasswordHasher() {

	}

	/*
	 * public static String generateHashedPassword(String pass) throws
	 * NoSuchAlgorithmException, InvalidKeySpecException {
	 * 
	 * final char[] password = pass.toCharArray(); final byte[] salt = getSalt();
	 * 
	 * final byte[] hashedPassword = getHash(password, salt, ITERATIONS,
	 * KEY_LENGTH);
	 * 
	 * return ITERATIONS + ":" + Hex.encodeHexString(salt) + ":" +
	 * Hex.encodeHexString(hashedPassword);
	 * 
	 * }
	 */

	public static String generateHashedPassword(char[] pass) throws NoSuchAlgorithmException, InvalidKeySpecException {

		final char[] password = pass;
		final byte[] salt = getSalt();

		final byte[] hashedPassword = getHash(password, salt, ITERATIONS, KEY_LENGTH);

		return ITERATIONS + ":" + Hex.encodeHexString(salt) + ":" + Hex.encodeHexString(hashedPassword);

	}

	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sRandom = new SecureRandom();
		byte[] salt = new byte[512];
		sRandom.nextBytes(salt);

		return salt;
	}

	private static byte[] getHash(char[] password, byte[] salt, int iterations, int keyLength)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGO_NAME);
		byte[] temp = secretKeyFactory.generateSecret(spec).getEncoded();

		return temp;
	}

	public static final boolean validateHashedPassword(char[] pass, String storedPass)
			throws DecoderException, NoSuchAlgorithmException, InvalidKeySpecException {

		String[] elements = storedPass.split(":");
		int iter = Integer.parseInt(elements[0]);
		byte[] salt = Hex.decodeHex(elements[1].toCharArray());
		byte[] hashedPass = Hex.decodeHex(elements[2].toCharArray());

		byte[] testPass = getHash(pass, salt, iter, KEY_LENGTH);

		if (Arrays.equals(hashedPass, testPass))
			return true;
		return false;
	}
}
