package database;

import junit.framework.TestCase;

public class HandleDatabaseTest extends TestCase {

	public void testCreate() {
		HandleDatabase handler = new HandleDatabase();
		handler.createAccount("test","pass");
		
		assertEquals(true, handler.databaseHasEntry("test"));
	}
	
	public void testGenerateHash() {
		HandleDatabase handler = new HandleDatabase();
		
		assertEquals(20, handler.generateHash("test").length());
	}
}
