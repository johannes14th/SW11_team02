package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class EmptyPassword extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testEmptyPassword() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.type("pwd", "");
		selenium.click("css=input[type=submit]");
		verifyTrue(selenium.isTextPresent("Passwort:"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
