package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class EnterWrongConfirmingPassword extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testEnterWrongConfirmingPassword() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.click("link=Registrieren");
		selenium.waitForPageToLoad("30000");
		selenium.type("css=form[name=loginFormRegister] > table > tbody > tr:nth(1) > td:nth(1) > input[name=username]", "neuerTest");
		selenium.click("//input[@value='Create']");
		verifyFalse(selenium.isTextPresent("Account successfully created!"));
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
