package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;

public class TestCreatePdf extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testCreatePdf() throws Exception {
		selenium.open("/WebTEXter/main.jsp");
		selenium.click("link=Startseite");
		selenium.waitForPageToLoad("30000");
		selenium.type("username", "neuerUser");
		selenium.type("pwd", "user");
		selenium.click("css=input[type=submit]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Dokumentenassistent");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.lunten > div.content > table > tbody > tr:nth(5) > td:nth(2) > a > font");
		selenium.waitForPageToLoad("30000");
		selenium.click("button");
		selenium.waitForPageToLoad("30000");
		selenium.type("author", "n");
		selenium.type("author", "b");
		selenium.type("date", "b");
		selenium.type("filename", "b");
		selenium.type("to", "b");
		selenium.type("bold", "b");
		selenium.type("bla", "b");
		selenium.type("gregor", "b");
		selenium.type("from", "b");
		selenium.type("irgendwas", "b");
		selenium.type("title", "b");
		selenium.type("text", "b");
		selenium.click("css=form[name=DataForm] > table > tbody > tr:nth(15) > td:nth(2) > input[name=button]");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent("PDF Successfully created"));
		verifyTrue(selenium.isTextPresent("pdf"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
