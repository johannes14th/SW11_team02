package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class RegisterWithExistingUsername extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testRegisterWithExistingUsername() throws Exception {
		selenium.open("/WebTEXter/impressum.jsp");
		selenium.click("link=Registrieren");
		selenium.waitForPageToLoad("30000");
		selenium.type("css=form[name=loginFormRegister] > table > tbody > tr:nth(1) > td:nth(1) > input[name=username]", "testUser");
		selenium.type("css=form[name=loginFormRegister] > table > tbody > tr:nth(2) > td:nth(1) > input[name=pwd]", "user");
		selenium.type("pwd2", "user");
		selenium.click("//input[@value='Create']");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Username already in use!"));
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
