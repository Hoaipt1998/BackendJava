package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/student?user=;password=";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "hoai1998");
		}catch(Exception e)
		{
			
		}
		return connection;
	}
}
