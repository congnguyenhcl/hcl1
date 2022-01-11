/*
 * Assume Employee has attributes as EmpID,EmpName,DOB,Salary,Age
1.To Insert the record in Employee DB input through command line arguments.
2.To reterive all the Employee informtion.
3.To reterive any employee record input given through command line arguments.
4.To update any particular employee record input given through command line arguments.
5.To delete any particular employee record input given through command line arguments.
5.Lets say you reterive all the employee information then you need to filter the records by the condition sal>5000 and employee name starts with B and age >21
Use maven project,proper java coding convention ,exception handling where ever you feel you can use Java 8 also.
 */

package com.hcl.cong.eam;

import java.sql.SQLException;

public class App {
	public static void main(String[] args) throws SQLException {
		Menu.displayMainMenu();
	}

}
