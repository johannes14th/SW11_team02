package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class WrongPassword extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
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

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
