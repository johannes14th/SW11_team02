package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class RegisterWithEmptyUsername extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testRegisterWithEmptyUsername() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.click("link=Registrieren");
		selenium.waitForPageToLoad("30000");
		selenium.type("css=form[name=loginFormRegister] > table > tbody > tr:nth(1) > td:nth(1) > input[name=username]", "");
		selenium.type("css=form[name=loginFormRegister] > table > tbody > tr:nth(2) > td:nth(1) > input[name=pwd]", "");
		selenium.type("css=form[name=loginFormRegister] > table > tbody > tr:nth(2) > td:nth(1) > input[name=pwd]", "test");
		selenium.type("pwd2", "test");
		selenium.click("//input[@value='Create']");
		verifyFalse(selenium.isTextPresent("Account successfully created!"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
