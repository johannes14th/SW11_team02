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
		addMessage(db, "Welcome","Willkommen","Welcome");
		addMessage(db, "Home","Startseite","Home");
		addMessage(db, "My","Mein WebTEXter","My WebTEXter");
		addMessage(db, "DocAssist","Dokumentenassistent", "Document Assistent");
		addMessage(db, "create_info", "Erstellen Sie neue Dokumente!","Create new documents!");
		addMessage(db, "edit_info", "Bearbeiten Sie bestehende Dokumente!","Edit existing documents!");
		addMessage(db, "generate_info", "Erzeugen Sie das fertige Dokument!","Generate your finished documents!");
		addMessage(db, "create", "Erstellen","Create");
		addMessage(db, "edit", "Bearbeiten","Edit");
		addMessage(db, "generate", "Fertig stellen","Generate");
		addMessage(db, "createTemplate_info", "Erstellen Sie neue Dokumente! W�hlen Sie dazu den gew�nschten Dateinamen.", "Create new documents! Please choose a filename.");
		addMessage(db, "Warning", "Achtung", "Warning");
		addMessage(db, "create_warning", "Erstellen Sie nur Dokumente mit der Endung .tex!", "Please create only documents with the extension .tex!");
		addMessage(db, "DocName", "Name des Dokuments", "Document name");
		addMessage(db, "InsertFileName", "Bitte einen Dateiname eingeben!", "Please insert a filename!");
		addMessage(db, "createDoc", "Dokument erstellen", "Create Document");
		addMessage(db, "Cancel", "Abbrechen", "Cancel");
		addMessage(db, "editTemplate_info", "Bearbeiten Sie Ihre Dokumente!\nW�hlen Sie dazu die gew�nschte Datei!","Edit your documents!\nChoose a file!");
		addMessage(db, "Open", "�ffnen", "Open");
		addMessage(db, "editDoc", "Dokument bearbeiten" ,"Edit Document");
		addMessage(db, "chooseTemplate", "W�hlen Sie das Dokument", "Choose a document");
		addMessage(db, "Profile", "Benutzerprofil", "User profile");
		addMessage(db, "ProfileInfo1", "Passen Sie WebTEXter Ihren pers�nlichen Bed�rfnissen an.", "Customize WebTEXter for your individual needs.");
		addMessage(db, "ProfileInfo2", "�ndern Sie einfach Ihre Spracheinstellungen oder legen Sie ein neues Passwort fest.", "Change your language settings or your password.");
		addMessage(db, "ProfileInfo3", "Bekommen Sie au�erdem einen �berblick �ber Ihre Dokumente und l�schen Sie diese nach Bedarf.", "Watch your documents and delete them if you want.");
		addMessage(db, "PersonalSettings", "Pers�nliche Einstellungen", "Personal settings");
		addMessage(db, "ChangePassword", "Passwort �ndern", "Change Password");
		addMessage(db, "NewPassword", "Neues Passwort", "New Password");
		addMessage(db, "ConfirmNewPassword", "Neues Passwort best�tigen", "Confirm new Password");
		addMessage(db, "PasswordChanged", "Passwort erfolgreich ge�ndert!", "Password succesfully changed!");
		addMessage(db, "MyFiles", "Meine Dokumente", "My Files");
		addMessage(db, "Documents", "Dokumente", "Documents");
		addMessage(db, "SavePassword", "Passwort �bernehmen", "Save Password");
		addMessage(db, "SaveLanguage", "Sprache �bernehmen", "Save Language");
		addMessage(db, "Delete", "L�schen", "Delete");
		
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
