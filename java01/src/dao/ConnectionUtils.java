package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getMyConnection() throws ClassNotFoundException, SQLException{
	String hostName = "localhost"	;
	String dbName = "demo1";
	String userName = "root";
	String password = "941997";
	return getMyConnection(hostName, dbName, userName, password) ;
	}

	public static Connection getMyConnection(String hostName, String dbName,
			String userName, String password) throws SQLException,
	        ClassNotFoundException {
		 Class.forName("com.mysql.jdbc.Driver");
		// TODO Auto-generated method stub
		 String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		 Connection conn = DriverManager.getConnection(connectionURL, userName,
		            password);
		
		    return conn;
	}
	
}
