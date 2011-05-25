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

	public void testGetMessage() {
		int userid_en = 0, userid_de = 0, userid_fr = 0;
		
		Vector<String> parameters_en = new Vector<String>();
		parameters_en.add("testuser_en");
		ResultSet rs_en = db.executeQuery(
				"SELECT userid FROM users WHERE username = ?;", parameters_en);

		Vector<String> parameters_de = new Vector<String>();
		parameters_de.add("testuser_de");
		ResultSet rs_de = db.executeQuery(
				"SELECT userid FROM users WHERE username = ?;", parameters_de);
		
		Vector<String> parameters_fr = new Vector<String>();
		parameters_fr.add("testuser_fr");
		ResultSet rs_fr = db.executeQuery(
				"SELECT userid FROM users WHERE username = ?;", parameters_fr);

		try {
			rs_en.next();
			rs_de.next();
			rs_fr.next();
			userid_en = rs_en.getInt("userid");
			userid_de = rs_de.getInt("userid");
			userid_fr = rs_fr.getInt("userid");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals("English",Translator.getMessage("test_message",userid_en));
		assertEquals("Deutsch",Translator.getMessage("test_message",userid_de));
		//Default language
		assertEquals("English",Translator.getMessage("test_message",userid_fr));
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
