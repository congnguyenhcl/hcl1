package com.hcl.cong.hibernate1.hibernate_demo1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This will create a table w/ the same name as the class name
public class Employee {
	@Id // This mark id as the primary column and create all column matching the names
		// of all subsequent variables

	private int id;
	private String firstName;
	private String lastName;
	private String job;
	private double salary;

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, String job, double salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getJob() {
		return job;
	}

	public double getSalary() {
		return salary;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", job=" + job
				+ ", salary=" + salary + "]";
	}

}
