package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import junit.framework.TestCase;

public class HandleDatabaseTest extends TestCase {

	public void testCreate() {
		HandleDatabase handler = new HandleDatabase();
		handler.createAccount("test","pass","en");
		
		assertEquals(true, handler.databaseHasEntry("test"));
	}
	
	public void testGenerateHash() {
		HandleDatabase handler = new HandleDatabase();
		
		assertEquals(20, handler.generateHash("test").length());
	}
	
	public void testPwdCorrect() throws SQLException {
		HandleDatabase handler = new HandleDatabase();
		handler.createAccount("neuerTest", "test","de");

		assertTrue(handler.checkPwd("neuerTest","test"));
	} 
	
	public void testGetLanguage() throws SQLException {
		HandleDatabase handler = new HandleDatabase();
		handler.createAccount("testGetLang","pass","en");
		
		String lang = handler.getLanguage("testGetLang");
		assertEquals(lang,"en");
	}
	
	public void testSetLanguage() throws SQLException {
		HandleDatabase handler = new HandleDatabase();
		handler.createAccount("testSetLang","pass","en");
		
		handler.setLanguage("testSetLang","de");
		
		assertEquals(handler.getLanguage("testSetLang"),"de");
	}
	
	public void testSetPassword() throws SQLException {
		HandleDatabase handler = new HandleDatabase();
		handler.createAccount("testSetPassword","pass","en");
		
		handler.setPassword("testSetPassword","test");
		
		assertTrue(handler.checkPwd("testSetPassword", "test"));
	}
	 
	protected void tearDown() throws Exception {
		Database db = new Database();
		Vector<String> parameters = new Vector<String>();
		parameters.add("test");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
			parameters);
		
		parameters.clear();
		parameters.add("neuerTest");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters);
		
		parameters.clear();
		parameters.add("testGetLang");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters);
		
		parameters.clear();
		parameters.add("testSetLang");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters);
		
		parameters.clear();
		parameters.add("testSetPassword");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters);
	}
}
