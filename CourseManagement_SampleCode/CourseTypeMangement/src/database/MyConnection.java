package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
			String connectionURL = "jdbc:mysql://localhost:3306/course?user=;password=";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "root", "123abc");
		}catch(Exception e)
		{
			
		}
		return connection;
	}
}
