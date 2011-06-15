package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class NotLoggedIn extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testNotLoggedIn() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.click("link=Startseite");
		selenium.waitForPageToLoad("30000");
		//verifyTrue(selenium.isTextPresent("Willkommen bei WebTEXter!"));
		selenium.click("link=Registrieren");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=form[name=loginFormRegister] > table > tbody > tr:nth(2) > td:nth(1) > input[name=pwd]"));
		assertTrue(selenium.isElementPresent("pwd2"));
		assertTrue(selenium.isElementPresent("css=form[name=loginFormRegister] > table > tbody > tr:nth(1) > td:nth(1) > input[name=username]"));
		selenium.click("link=Impressum");
		selenium.waitForPageToLoad("30000");
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
