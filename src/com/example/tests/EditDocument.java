package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class EditDocument extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testEditDocument() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.type("username", "neuerTest");
		selenium.type("pwd", "test");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.open("/WebTEXter/templateAssistant.jsp");
		selenium.click("css=div.lunten > div.content > table > tbody > tr:nth(3) > td:nth(2) > a > font");
		selenium.waitForPageToLoad("30000");
		selenium.click("button");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent(""));
		selenium.type("input", "Test");
		selenium.click("css=div.lunten > div.content > table:nth(1) > tbody > tr:nth(2) > td > table > tbody > tr:nth(2) > td > input[name=button]");
		selenium.waitForPageToLoad("30000");
		selenium.click("button");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isTextPresent("Content:"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
