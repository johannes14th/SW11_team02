package com.example.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestSuiteGui {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(NotLoggedIn.class);
		suite.addTestSuite(Register.class);
		suite.addTestSuite(LoggedIn.class);
		suite.addTestSuite(CreateDocument.class);
		suite.addTestSuite(CancelCreatingDocument.class);
		suite.addTestSuite(EditDocument.class);
		suite.addTestSuite(CancelEditDocument.class);
		suite.addTestSuite(WrongPassword.class);
		suite.addTestSuite(EmptyUsername.class);
		suite.addTestSuite(EmptyPassword.class);
		suite.addTestSuite(RegisterWithExistingUsername.class);
		suite.addTestSuite(EnterWrongConfirmingPassword.class);
		suite.addTestSuite(RegisterWithEmptyUsername.class);
		suite.addTestSuite(Logout.class);
		suite.addTestSuite(TestCreateDocx.class);
		suite.addTestSuite(TestCreateTex.class);
		suite.addTestSuite(TestCreatePdf.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
