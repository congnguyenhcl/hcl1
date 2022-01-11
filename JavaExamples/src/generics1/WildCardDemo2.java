package generics1;

import java.util.Arrays;
import java.util.List;

class WildCard2 {
	static void printStuff(List<?> list) {
		for (Object l : list) {
			System.out.print(l);
		}
	}
}

class Person {
	String name;

	Person(String n) {
		name = n;
	}
}

public class WildCardDemo2 {
	public static void main(String[] args) {
		List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5);
		List<Person> listPerson = Arrays.asList(new Person("Bob"));
		WildCard2.printStuff(listInteger);
		WildCard2.printStuff(listPerson);
	}
}