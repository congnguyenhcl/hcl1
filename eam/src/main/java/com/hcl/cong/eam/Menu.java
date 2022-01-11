package com.hcl.cong.eam;

import java.util.Scanner;

public class Menu {
	public static void displayMainMenu() {
		DatabaseInfo.init();
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Please type a number to execute a command: ");
			System.out.println();
			System.out.println("1- [INSERT] a record");
			System.out.println("2- [SELECT] all Employee information");
			System.out.println("3- [SELECT] a record for a specific employee");
			System.out.println("4- [UPDATE] a record for a specific employee");
			System.out.println("5- [DELETE] a record for a specific employee");
			System.out.println(
					"6- [SELECT] a record for employees whose Salary > 5000 AND Age > 21 AND First_Name begins with B");
			System.out.println("Q- Press Q to exit the program");
			String selection = input.next();
			if (selection.equalsIgnoreCase("Q")) {
				System.out.println();
				System.out.println("Exiting program. Have a good day!");
				System.exit(0);
			} else if (selection.equalsIgnoreCase("")) {
				System.out.println("Please enter a valid response");
				displayMainMenu();
			} else {
				if (selection.equalsIgnoreCase("1")) {

					displayInsertMenu();
				} else if (selection.equals("2")) {
					SelectStatement ss = new SelectStatement();
					ss.selectAll();
					displayMainMenu();
				} else if (selection.equalsIgnoreCase("3")) {
					System.out.println("Please enter an employee ID: ");
					SelectStatement ss = new SelectStatement();
					ss.selectSpecific(input.next());
					displayMainMenu();
					System.out.println();
				} else if (selection.equalsIgnoreCase("4")) {
					displayUpdateMenu();
				} else if (selection.equalsIgnoreCase("5")) {
					displayDeleteMenu();
				} else if (selection.equalsIgnoreCase("6")) {
					SelectStatement ss = new SelectStatement();
					ss.selectFilter();
				}
			}
		}
	}

	public static void displayInsertMenu() {
		try (Scanner input1 = new Scanner(System.in)) {
			System.out.println("Press ENTER to begin [inserting] data");
			System.out.println("Press R to return to the previous menu");
			System.out.println("Press Q to exit the program");
			System.out.println();
			String selection1 = input1.nextLine();
			if (selection1.equalsIgnoreCase("R")) {
				displayMainMenu();
			} else if (selection1.equalsIgnoreCase("Q")) {
				System.out.println();
				System.out.println("Exiting program. Have a good day!");
				System.exit(0);
			} else if (selection1.equals("")) {
				System.out.println("Enter employee [First_Name]");
				InsertStatement.fn = input1.nextLine();
				System.out.println("Enter employee [Last_Name]");
				InsertStatement.ln = input1.next();
				System.out.println("Enter employee [Year_Of_Birth] (1900 through 2003) ");
				InsertStatement.yob = input1.next();
				System.out.println("Enter employee [Month_Of_Birth] (January through December)");
				InsertStatement.mob = input1.next();
				System.out.println("Enter employee [Day_Of_Birth] (1 through 31)");
				InsertStatement.dayob = input1.next();
				System.out.println("Enter employee Salary (Whole number only)");
				InsertStatement.s = input1.next();
				InsertStatement.insert();
			} else {
				System.out.println("Please enter a valid response");
				displayInsertMenu();
			}
		}
	}

	public static void displayUpdateMenu() {
		try (Scanner input2 = new Scanner(System.in)) {
			System.out.println("Press ENTER to begin [updating] data");
			System.out.println("Press R to return to the previous menu");
			System.out.println("Press Q to exit the program");
			System.out.println();
			String selection2 = input2.nextLine();
			if (selection2.equalsIgnoreCase("R")) {
				displayMainMenu();
			} else if (selection2.equalsIgnoreCase("Q")) {
				System.out.println();
				System.out.println("Exiting program. Have a good day!");
				System.exit(0);
			} else if (selection2.equals("")) {
				System.out.println("Enter employee [ID] to update");
				String tempID = input2.next();
				System.out.println("Enter employee column to update");
				System.out.println("Available column to update are: (Type a number to select)");
				System.out.println("1- First_Name");
				System.out.println("2- Last_Name");
				System.out.println("3- Year_Of_Birth");
				System.out.println("4- Month_Of_Birth");
				System.out.println("5- Day_Of_Birth");
				System.out.println("6- Salary");
				String tempColumn = input2.next();
				System.out.println("Enter new data appropriately for the chosen column");
				String tempData = input2.next();
				UpdateStatement us = new UpdateStatement();
				us.update(tempID, tempColumn, tempData);
				displayMainMenu();
			} else {
				System.out.println("Please enter a valid response");
				displayUpdateMenu();
			}
		}
	}

	public static void displayDeleteMenu() {
		try (Scanner input3 = new Scanner(System.in)) {
			System.out.println("Press ENTER to begin [deleting] data");
			System.out.println("Press R to return to the previous menu");
			System.out.println("Press Q to exit the program");
			System.out.println();
			String selection3 = input3.nextLine();
			if (selection3.equalsIgnoreCase("R")) {
				displayMainMenu();
			} else if (selection3.equalsIgnoreCase("Q")) {
				System.out.println();
				System.out.println("Exiting program. Have a good day!");
				System.exit(0);
			} else if (selection3.equals("")) {
				System.out.println("Enter employee [ID] to delete");
				String tempID = input3.next();
				DeleteStatement ds = new DeleteStatement();
				ds.delete(tempID);
				displayMainMenu();
			} else {
				System.out.println("Please enter a valid response");
				displayDeleteMenu();
			}
		}

	}
}