package database;

import junit.framework.TestCase;

public class DatabaseTest extends TestCase {
	

	public void testConnection() {
		Database database = new Database();
		
		assertEquals(true,database.connect());
	}
	
	public void testDatabaseCreation() {
		Database database = new Database();
		
		database.createUserTable();
		assertEquals(true, database.tableExists("users"));
		
		database.createMessagesTable();
		assertEquals(true, database.tableExists("messages"));
	}

}
