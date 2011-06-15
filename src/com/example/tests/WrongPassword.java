package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class WrongPassword extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testWrongPassword() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.type("username", "neuerTest");
		selenium.type("pwd", "t");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Wrong password!"));
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
