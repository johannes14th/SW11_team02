package com.example.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class CreateDocument extends SeleneseTestCase {
	@Override
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testCreateDocument() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.type("username", "neuerTest");
		selenium.type("pwd", "test");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.open("/WebTEXter/templateAssistant.jsp");
		selenium.click("css=font");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent(""));
		assertTrue(selenium.isElementPresent("filename"));
		selenium.type("filename", "neuesFile.tex");
		selenium.click("button");
		selenium.waitForPageToLoad("30000");
		selenium.type("input", "Irgendwas");
		selenium.click("button");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("saved"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	@Override
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
