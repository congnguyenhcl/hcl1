package com.hcl.cong.eam;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectStatement {

	void selectAll() {
		ArrayList<List<String>> data = new ArrayList<List<String>>();
		try {
			String querry = "Select * FROM eam.employee";
			System.out.println("Executed querry was " + querry);
			PreparedStatement selectPs = DatabaseInfo.connection.prepareStatement(querry);
			ResultSet rs = selectPs.executeQuery();
			while (rs.next()) {
				data.add(Arrays.asList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}

			if (data.size() < 0) {
				System.err.println("There is no data to display");
			} else {
				for (int i = 0; i < data.size(); i++)
					System.out.println(data.get(i));
				System.out.println();
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	void selectSpecific(String tempID) {
		ArrayList<List<String>> data = new ArrayList<List<String>>();
		try {
			String querry = "SELECT * FROM eam.employee WHERE ID=?";
			PreparedStatement selectPs = DatabaseInfo.connection.prepareStatement(querry);
			selectPs.setString(1, tempID);
			ResultSet rs = selectPs.executeQuery();
			while (rs.next()) {
				data.add(Arrays.asList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}
			for (int i = 0; i < data.size(); i++)
				System.out.println(data.get(i));
			System.out.println();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	void selectLast() {
		ArrayList<List<String>> data = new ArrayList<List<String>>();
		try {
			String querry = "SELECT * FROM eam.employee ORDER BY ID DESC LIMIT 1;";
			PreparedStatement selectPs = DatabaseInfo.connection.prepareStatement(querry);
			ResultSet rs = selectPs.executeQuery();
			while (rs.next()) {
				data.add(Arrays.asList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}
			for (int i = 0; i < data.size(); i++)
				System.out.println(data.get(i));
			System.out.println();

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	void selectFilter() {
		ArrayList<List<String>> data = new ArrayList<List<String>>();
		try {
			String querry = "SELECT * FROM eam.employee where Salary > '5000' AND Age > '21' AND First_Name REGEXP '^[b-z]'";
			PreparedStatement selectPs = DatabaseInfo.connection.prepareStatement(querry);
			ResultSet rs = selectPs.executeQuery();
			while (rs.next()) {
				data.add(Arrays.asList(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10)));
			}
			for (int i = 0; i < data.size(); i++)
				System.out.println(data.get(i));
			System.out.println();
			Menu.displayMainMenu();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}