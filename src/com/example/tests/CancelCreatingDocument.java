package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class CancelCreatingDocument extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testCancelCreatingDocument() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.type("username", "neuerTest");
		selenium.type("pwd", "test");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.open("/WebTEXter/templateAssistant.jsp");
		selenium.click("css=font");
		selenium.waitForPageToLoad("30000");
		selenium.click("//input[@name='button' and @value='Abbrechen']");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("Dokumentenassistent"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
