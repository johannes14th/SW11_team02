package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Vector;
import java.sql.DriverManager;

public class Database {

	Connection con_;

	public Database() {
		// TODO Auto-generated constructor stub
		connect();
	}

	public Database(Connection conn) {
		// TODO Auto-generated constructor stub
		con_ = conn;
	}

	public void createUserTable() {
		// TODO Auto-generated method stub

		if (!tableExists("users")) {
			String sql = "Create Table users( userid int NOT NULL auto_increment, username VARCHAR(30) NOT NULL, pass text NOT NULL, language varchar(2) NOT NULL, PRIMARY KEY(userid), UNIQUE KEY(username))";
			PreparedStatement stmt;
			try {
				stmt = con_.prepareStatement(sql);
				stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void createMessagesTable() {
		// TODO Auto-generated method stub

		String sql = "CREATE TABLE IF NOT EXISTS messages (";
		sql += "keyword VARCHAR(20) NOT NULL, ";
		sql += "de text NOT NULL, ";
		sql += "en text NOT NULL,";
		sql += "PRIMARY KEY(keyword));";
		
		PreparedStatement stmt;
		try {
			stmt = con_.prepareStatement(sql);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean tableExists(String table) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM " + table;
		PreparedStatement stmt;
		try {
			stmt = con_.prepareStatement(sql);
			stmt.executeQuery();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return false;
		}
	}

	public boolean connect() {
		// TODO Auto-generated method stub
		try {
			String treiber = "com.mysql.jdbc.Driver";
			Class.forName(treiber);
			String host = "jdbc:mysql://localhost/swt11";

			Properties props = new Properties();
			props.put("user", "root");
			props.put("password", "");//"040386");
			con_ = DriverManager.getConnection(host, props);
			con_.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			con_.setAutoCommit(false);
			con_.rollback();
			return true;
		}

		catch (java.lang.Exception ex) {
			System.err.println(ex.getLocalizedMessage());
			System.err.println("mist");
			return false;
		}
	}

	public ResultSet executeQuery(String sql, Vector<String> parameters) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		ResultSet set = null;
		try {
			stmt = con_.prepareStatement(sql);

			for (int index = 1; index <= parameters.size(); index++)
				stmt.setString(index, parameters.elementAt(index - 1));

			return stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return set;

	}

	public void executeStatement(String sql, Vector<String> parameters) {
		// TODO Auto-generated method stub
		PreparedStatement stmt;
		try {
			stmt = con_.prepareStatement(sql);

			for (int index = 1; index <= parameters.size(); index++)
				stmt.setString(index, parameters.elementAt(index - 1));

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
