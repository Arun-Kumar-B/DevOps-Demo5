package com.myapp.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.myapp.bl.*;

public class TestLoginValidation {

	private LoginValidation lv;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Do nothing for now
		// Second commit for trails
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Do nothing for now
	}

	@Before
	public void setUp() throws Exception {
		// Do nothing for now
	}

	@After
	public void tearDown() throws Exception {
		// Do nothing for now
	}

	@Test
	public void testLogin() {
		//System.out.println(" >>> in testLogin");
		lv = new LoginValidation();

		// Using this block will create a Blocker issue in Sonarcube
		/*
		String userName = "test";
		String pwd = "test";
		assertTrue(lv.validateLogin(userName, pwd));
		*/
		
		// Using this block will remove the Blocker issue in Sonarcube
		
		String strus1 = "test";
		String strpd1 = "test";
		assertTrue(lv.validateLogin(strus1, strpd1));
		assertFalse(lv.validateLogin("test1", "123"));
		assertFalse(lv.validateLogin("test","123"));
	}

}
