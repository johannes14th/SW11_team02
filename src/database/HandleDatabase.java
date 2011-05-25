package database;

import iaik.asn1.structures.AlgorithmID;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class HandleDatabase {
	
	Database database_;
	
	public HandleDatabase () {
		database_ = new Database();
	}
	
	public HandleDatabase (Connection con) {
		database_ = new Database(con);
	}

	public void createAccount(String username, String password, String language) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO users (username, pass, language) VALUES (?,?,?) ";
		Vector<String> parameters = new Vector<String>();
		parameters.add(username);
		parameters.add(generateHash(password));
		parameters.add(language);
		
		database_.executeStatement(sql, parameters);
	}

	public boolean databaseHasEntry(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM users WHERE username = ?";
		Vector<String> parameters = new Vector<String>();
		parameters.add(username);
		
		ResultSet set = database_.executeQuery(sql, parameters);
		
		try {
			return set.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String generateHash(String message) {
		
    	AlgorithmID hashAlgorithm = AlgorithmID.sha1; // e.g. AlgorithmID.sha1
        MessageDigest hashEngine = null;
		try {
			hashEngine = MessageDigest.getInstance(hashAlgorithm.getImplementationName());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
        
        byte[] rawHash = hashEngine.digest(message.getBytes());
        
	
		return new String(rawHash);
	}

}
