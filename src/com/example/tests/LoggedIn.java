package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class LoggedIn extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testLoggedIn() throws Exception {
		selenium.open("/WebTEXter/login.jsp");
		selenium.type("username", "testUser");
		selenium.type("pwd", "user");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Mein WebTEXter");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Dokumentenassistent");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent(""));
		verifyTrue(selenium.isTextPresent(""));
		verifyTrue(selenium.isTextPresent(""));
		selenium.click("link=MyFiles");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent(".docx"));
		verifyTrue(selenium.isTextPresent(".pdf"));
		verifyTrue(selenium.isTextPresent(".xml"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}