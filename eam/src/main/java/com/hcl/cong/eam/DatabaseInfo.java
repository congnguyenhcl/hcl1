package com.hcl.cong.eam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInfo {
	static Connection connection;

	public static void init() {
		String url = "jdbc:mySQL://localhost:3306/eam";
		String username = "root";
		String password = "admin";
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}