package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection  {
	private static Connection conn;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/medi_care","root", "");
		}
		catch(Exception e) {
			System.out.print(e);
		}
		return conn;
	}

}
