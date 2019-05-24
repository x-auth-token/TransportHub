package com.pl.transporthub.util;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.DecoderException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.pl.transporthub.aaa.PasswordHasher;

public class PasswordHasherTest {

	public static final char[] pass = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };
	public static final char[] pass2 = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '2' };;
	public static final char[] pass3 = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '3' };

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testGenerateHashedPassword() {

		try {
			String sp = PasswordHasher.generateHashedPassword(pass);
			String sp2 = PasswordHasher.generateHashedPassword(pass2);
			// Assert.assertNotEquals(sp, sp2);
			assertNotEquals(sp2, sp);

		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testValidateHashedPassword() {

		try {
			final String saltedPass = PasswordHasher.generateHashedPassword(pass);
			System.out.println(saltedPass);
			assertTrue(PasswordHasher.validateHashedPassword(pass, saltedPass));
		} catch (DecoderException | InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

}
