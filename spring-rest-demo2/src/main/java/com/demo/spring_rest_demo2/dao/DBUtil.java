package com.demo.spring_rest_demo2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn = null;
	
	static {
		// step 1
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static Connection makeConnection() {
		// step 2
		String connectionUrl = "jdbc:mysql://localhost:3306/propertydatabase";
		String user = "root";
		String password = "root";
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(connectionUrl, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	static void closeConnection() {
		// step 5
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
