package com.hcl.cong.eam;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

public class InsertStatement {
	static String fn, ln, yob, mob, dayob, s;

	static void insert() {
		try {
			String querry = "INSERT INTO eam.employee VALUES (default,?,?,default,?,?,?,?,default,default)";
			PreparedStatement insertPs = DatabaseInfo.connection.prepareStatement(querry);

			insertPs.setString(1, StringUtils.capitalize(fn));
			insertPs.setString(2, StringUtils.capitalize(ln));

			insertPs.setString(3, yob);
			insertPs.setString(4, StringUtils.capitalize(mob));
			insertPs.setString(5, dayob);
			insertPs.setString(6, s);

			insertPs.executeUpdate();
			System.out.println("Operation completed successfully");
			System.out.println();
			System.out.println("Please review your added record");
			System.out.println();
			SelectStatement ss = new SelectStatement();
			ss.selectLast();
			Menu.displayMainMenu();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}