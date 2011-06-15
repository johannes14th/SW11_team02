package translator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import database.Database;

import junit.framework.TestCase;

public class TestTranslator extends TestCase {

	Database db = new Database();


	protected void setUp() throws Exception {
		super.setUp();
		// Testuser erstellen
		
		InsertMessagesIntoDB.createMessageTable();
		
		Vector<String> parameters_en = new Vector<String>();
		parameters_en.add("testuser_en");
		parameters_en.add("test");
		parameters_en.add("en");
		db.executeStatement(
				"INSERT INTO users (username,pass,language) VALUES (?,?,?);",
				parameters_en);

		Vector<String> parameters_de = new Vector<String>();
		parameters_de.add("testuser_de");
		parameters_de.add("test");
		parameters_de.add("de");
		db.executeStatement(
				"INSERT INTO users (username,pass,language) VALUES (?,?,?);",
				parameters_de);
		
		Vector<String> parameters_fr = new Vector<String>();
		parameters_fr.add("testuser_fr");
		parameters_fr.add("test");
		parameters_fr.add("fr");
		db.executeStatement(
				"INSERT INTO users (username,pass,language) VALUES (?,?,?);",
				parameters_fr);

		Vector<String> message_parameters = new Vector<String>();
		message_parameters.add("test_message");
		message_parameters.add("Deutsch");
		message_parameters.add("English");
		db.executeStatement(
				"INSERT INTO messages (keyword,de,en) VALUES (?,?,?);",
				message_parameters);

	}

	public void testGetMessageEN() {
		assertEquals("English",Translator.getMessage("test_message","testuser_en"));
	}
	public void testGetMessageDE() {
		assertEquals("Deutsch",Translator.getMessage("test_message","testuser_de"));
	}

	public void testGetMessageDefault() {
		assertEquals("English",Translator.getMessage("test_message","testuser_fr"));
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		// Testuser löschen
		Vector<String> parameters_en = new Vector<String>();
		parameters_en.add("testuser_en");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters_en);

		Vector<String> parameters_de = new Vector<String>();
		parameters_de.add("testuser_de");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters_de);
		
		Vector<String> parameters_fr = new Vector<String>();
		parameters_fr.add("testuser_fr");
		db.executeStatement("DELETE FROM users WHERE username = ?;",
				parameters_fr);

		Vector<String> message_parameters = new Vector<String>();
		message_parameters.add("test_message");
		db.executeStatement("DELETE FROM messages WHERE keyword = ?;",
				message_parameters);
	}

}
