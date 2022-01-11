package com.hcl.cong.eam;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

public class UpdateStatement {
	void update(String tempId, String tempColumn, String tempData) {
		switch (tempColumn) {
		case "1":
			tempColumn = "First_Name";
			break;
		case "2":
			tempColumn = "Last_Name";
			break;
		case "3":
			tempColumn = "Year_Of_Birth";
		case "4":
			tempColumn = "Month_Of_Birth";
		case "5":
			tempColumn = "Day_Of_Birth";
		case "6":
			tempColumn = "Salary";
		}
		try {
			String querry = "UPDATE eam.employee SET " + tempColumn + "=? WHERE ID=?";
			PreparedStatement selectPs = DatabaseInfo.connection.prepareStatement(querry);
			selectPs.setString(1, StringUtils.capitalize(tempData));
			selectPs.setString(2, tempId);
			selectPs.executeUpdate();
			System.out.println();
			System.out.println("Operation completed successfully\n");
			System.out.println("Please verify your updated record \t");
			System.out.println();
			SelectStatement ss = new SelectStatement();
			ss.selectSpecific(tempId);

		} catch (SQLException e) {
			System.out.println(e);
		}

	}
}