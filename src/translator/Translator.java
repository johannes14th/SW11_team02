package translator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import database.Database;

public class Translator {

	public static String getMessage(String keyword, String username) {
		Database db = new Database();
		String language = "";
		String message = "";

		Vector<String> parameters = new Vector<String>();

		//--------------------------get Language from user---------------------------
		ResultSet rs = db.executeQuery(
				"SELECT language FROM users WHERE username = '" + username + "';",
				parameters);

		try {
			rs.next();
			language = rs.getString("language");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//----------------------------get Message----------------------------------------
		parameters.add(keyword);

		rs = db.executeQuery("SELECT " + language + " FROM messages WHERE keyword = ?;",
				parameters);
		try {
			if (rs == null) {
				//set Default Language 'en'
				parameters.clear();
				language = "en";
				parameters.add(keyword);
				rs = db.executeQuery(
						"SELECT * FROM messages WHERE keyword = ?;", parameters);
			}

			if (!rs.next()) {
				//keyword not found in DB
				return "!-- No Message for keyword: '" + keyword + "' --!";
			}

			message = rs.getString(language);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return message;
	}


}
