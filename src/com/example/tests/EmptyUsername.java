package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class EmptyUsername extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testEmptyUsername() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.type("username", "");
		selenium.type("pwd", "");
		selenium.click("css=input[type=submit]");
		verifyTrue(selenium.isTextPresent("Passwort:"));
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
