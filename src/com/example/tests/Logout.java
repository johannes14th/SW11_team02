package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class Logout extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testLogout() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.type("username", "neuerTest");
		selenium.type("pwd", "test");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Passwort:"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
