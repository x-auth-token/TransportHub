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
