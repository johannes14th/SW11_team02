package database;

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
	
	protected void tearDown() throws Exception {
		Database db = new Database();
		Vector<String> parameters = new Vector<String>();
		parameters.add("test");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters);
	}
	
	 public void testPwdCorrect() throws SQLException {
		 HandleDatabase handler = new HandleDatabase();
		 handler.createAccount("neuerTest", "test","deutsch");
		 assertTrue(handler.checkPwd("neuerTest","test"));
	 } 
}
