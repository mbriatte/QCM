package com.mika.jwt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void test() {
		String jwt=JwtGenerator.createJWT("michael", "ceci est un test", "merci", 1000000);
		assertNotNull(jwt);
		System.out.println(jwt);
		JwtGenerator.parseJWT(jwt);
		assert(true);
	}

}
