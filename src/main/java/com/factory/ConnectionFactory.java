package com.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	  
	public static Connection getConnection() {
		  String url = "jdbc:mysql://localhost:3306/Portfolio"; // DB URL (change DB name)
	      String user = "root";  // DB username
	      String password = "Shivam@9713"; // DB password
	      Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
