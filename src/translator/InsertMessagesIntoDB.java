package translator;

import java.util.Vector;

import database.Database;

public class InsertMessagesIntoDB {

	public static void createMessageTable()
	{
		Database db = new Database();
		
		db.createMessagesTable();
		
		addMessage(db, "createNewTemplate.jsp","Bitte Templatename eingeben!", "Templatename must filled out!");
		addMessage(db, "Filename","Dateiname", "Filename");
		addMessage(db, "Templatename","Templatename", "Templatename");
		addMessage(db, "createNewTemplate.jsp","Dateiname eingeben!", "Please insert a filename!");
		addMessage(db, "template_created","Template erfolgreich erstellt!", "Template successfully created!");
		addMessage(db, "Path","Pfad", "Path");
		addMessage(db, "Extension","Falsche Dateiendung!", "No valid Extension!");
		//addMessage(db, "Filename","Dateiname", "Filename");
		//addMessage(db, "Filename","Dateiname", "Filename");
		
		
		
	}
	
	private static void addMessage(Database db, String keyword, String de, String en)
	{
		Vector<String> message_parameters = new Vector<String>();
		message_parameters.add(keyword);
		message_parameters.add(de);
		message_parameters.add(en);
		db.executeStatement(
				"INSERT INTO messages (keyword,de,en) VALUES (?,?,?);",
				message_parameters);
		
	}
}
