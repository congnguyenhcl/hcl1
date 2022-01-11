package com.hcl.cong.eam;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStatement {
	public void delete(String tempId) {
		try {
			String querry = "DELETE FROM eam.employee WHERE ID =?";
			DatabaseInfo.init();
			PreparedStatement selectPs = DatabaseInfo.connection.prepareStatement(querry);
			selectPs.setString(1, tempId);
			selectPs.executeUpdate();
			System.out.println();
			System.out.println("Operation completed successfully\n");
			System.out.println("Please verify your updated table \t");
			System.out.println();
			SelectStatement ss = new SelectStatement();
			ss.selectAll();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}