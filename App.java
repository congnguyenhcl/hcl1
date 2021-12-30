package stream1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
	String name, id, dob;
	int age, salary;

	public Person(String id, String name, String dob, int age, int salary) {
		this.name = name;
		this.id = id;
		this.dob = dob;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + ", dob=" + dob + ", age=" + age + ", salary=" + salary + "]";
	}

}

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> foo = Arrays.asList(
				new Person("1", "Bob", "111990", 20, 10000),
				new Person("2", "Sue", "222000", 31, 5000), 
				new Person("3", "Tom", "331980", 25, 20000),
				new Person("3", "Max", "331980", 59, 8000));
		// Get Bob
		List<Person> result = foo.stream().filter(x -> (x.getAge() > 30)).collect(Collectors.toList());

		System.out.println(result);

		List<Person> result1 = foo.stream().filter(x -> (x.getAge() > 50 && x.getAge() < 60))
				.collect(Collectors.toList());
		System.out.println(result1);

		List<Person> result2 = foo.stream().filter(x -> (x.getSalary() > 10000)).collect(Collectors.toList());
		System.out.println(result2);

	}

}

//1.Lets say there is Employee list it has EmpId,Emp Name,DOB,Age and Salary,First You need to create sample data that satisfy the given below conditions.
//
//2.Write a Java Stream statment to filter the employee record whose age is greater than 30
//
//3.Write a Java Stream statment to filter the employee record whose age is between 50 and 60.
//
//4Write a Java Stream statment to filter the employee record whose salary is greater than 10000.
