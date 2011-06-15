package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class LoggedIn extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testLoggedIn() throws Exception {
		selenium.open("/WebTEXter/login.jsp");
		selenium.type("username", "neuerTest");
		selenium.type("pwd", "test");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Mein WebTEXter");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Dokumentenassistent");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent(""));
		verifyTrue(selenium.isTextPresent(""));
		verifyTrue(selenium.isTextPresent(""));
		selenium.click("link=Mein WebTEXter");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent(".docx"));
		verifyTrue(selenium.isTextPresent(".pdf"));
		verifyTrue(selenium.isTextPresent(".xml"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
