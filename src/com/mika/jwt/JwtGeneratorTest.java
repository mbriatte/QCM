package com.mika.jwt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

public class JwtGeneratorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEncryptDecryptJetonNormal() {
		String jwt=JwtGenerator.createJWT("1", "Issuer1", "acces", 1000000,false);
		assertNotNull(jwt);
		System.out.println(jwt);
		Claims jetton=JwtGenerator.parseJWTwithKey(jwt);
		assertNotNull(jetton);
		assertEquals(jetton.getId(),"1");
		assertEquals(jetton.getIssuer(),"Issuer1");
	}
	
	@Test
	public void testEncryptDecryptJetonVIP() {
		String jwt=JwtGenerator.createJWT("2", "Issuer2", "access", 1000000,true);
		assertNotNull(jwt);
		System.out.println(jwt);
		Claims jetton=JwtGenerator.parseJWTwithKeyhintinKeyID(jwt);
		assertNotNull(jetton);
		assertEquals(jetton.getId(),"2");
	}
	
	@Test
	public void testexperation () {
		String jwt=JwtGenerator.createJWT("2", "Issuer2", "access", 10,true);
		assertNotNull(jwt);
		System.out.println(jwt);
		Claims jetton=null;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		try
		{
			jetton=JwtGenerator.parseJWTwithKeyhintinKeyID(jwt);
			// le jeton est normalement exprirée
			fail();
		}
		catch (ExpiredJwtException e)
		{
			assertNull(jetton);
		}
		
	}
	
	
	@Test
	public void testdecryptageKOavecClefNormal() {
		String jwt=JwtGenerator.createJWT("2", "Issuer2", "access", 1000000, true);
		assertNotNull(jwt);
		System.out.println(jwt);
		Claims jetton=null;
		try
		{
			jetton=JwtGenerator.parseJWTwithKey(jwt);
			// si on arrive la c'est qu'il y a un pb puisque le jeton ne peut pas etre decrypté avec la clef normal
			fail();
			
		}
		catch( Exception e)
		{
			
		}
		assertNull(jetton);
		
	}
	

	
	
}
