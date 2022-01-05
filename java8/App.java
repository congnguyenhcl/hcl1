package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Write an example for each concept
 *  Lambda expressions,
    Method references,
    Functional interfaces,
    Stream API,Paralle Stream,
    Default methods,
    Static methods in interface,
    Optional class,
    Collectors class,
    ForEach() method,
    Predicate,Supplier,Consumer,
    BiFunction examples
 */
interface i1 {
	int getNum();

	default int getNumv2(int i) {
		return i;
	}
}

class A {

	public i1 i1v2(i1 i) {
		return i;
	}

	public int getNum() {
		return 100;
	}
}

class B implements i1 {

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}

class Employee {
	String name;
	int salary, age;

	public Employee(String name, int salary, int age) {

		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class App {

	public static void main(String[] args) {
		/*
		 * lambda expression - takes in no argument and returns an int functional
		 * interface - mynumber is a functional interface because it has only one
		 * abstract method
		 */
		i1 x = () -> 123;
		System.out.println(x.getNum());

		/*
		 * Method reference - class A i1v2 method takes in an i1 object and return that
		 * object We can simply pass in an i1 object or use lambda express to pass in an
		 * i1 object
		 */
		A a = new A();
		// Pass i1 object in using lambda express
		System.out.println(a.i1v2(() -> 100).getNum());

		/*
		 * Pass i1 object in using method reference class A getNum() method is similar
		 * to i1 getNum() method because it takes in no argument and return an int, thus
		 * it defines the implementation of i1 getNum() method
		 */
		System.out.println(a.i1v2(a::getNum).getNum());

		/*
		 * default interface method class B implements i1 interface hence gains access
		 * to its default method getNumv2()
		 */
		B b = new B();
		int foo = b.getNumv2(456);
		System.out.println(foo);
		/*
		 * 
		 */

		/*
		 * Predicate is a functional interface with the boolean test(T t) method that
		 * returns a boolean evaluating two objects for equality
		 */
		Predicate<Integer> isEven = (i) -> i % 2 == 0;
		System.out.println(isEven.test(3));

		/*
		 * Supplier is a functional interface with the T get() method that takes in a
		 * object of type T and returns it
		 */
		Supplier<Integer> prettyNum = () -> 200;
		System.out.println(prettyNum.get());

		/*
		 * Consumer is a functional interface with the void accept(T t) method that
		 * takes an object of type T and returns nothing
		 */
		Consumer<Integer> myConsumer = c -> System.out.println(c);
		myConsumer.accept(500);

		/*
		 * Stream
		 */
		List<Integer> al = Arrays.asList(1, 2, 4, 5);
		System.out.println(al);
		Stream<Integer> alStream = al.stream();
		Optional<Integer> isEvenOptional = alStream.min(Integer::compare);
		System.out.println(isEvenOptional);
		alStream = al.stream();
		List<Integer> isEvenList = alStream.filter(isEven).collect(Collectors.toList());
		System.out.println(isEvenList);

		/*
		 * parallelStream() and bifunction
		 */
		int z = al.parallelStream().reduce(0, (v1, v2) -> v1 + v2, (v1, v2) -> v1 + v2);
		System.out.println(z);

		/*
		 * foreach
		 */
		al.forEach(myConsumer);

		Employee e1 = new Employee("Bob", 2000, 20);
		Employee e2 = new Employee("Doe", 1000, 40);
		Employee e3 = new Employee("Joe", 3000, 40);
		ArrayList<Employee> eArrayList = new ArrayList<Employee>();
		eArrayList.add(e1);
		eArrayList.add(e2);
		List<Employee> result = eArrayList.stream()
				.filter(e -> e.getAge() > 30 & e.getSalary() > 1000 & e.getName().charAt(0) == 'B'
						|| e.getName().charAt(0) == 'D')
				.collect(Collectors.toList());
		result.forEach(v->System.out.println(v.getName()+" "+v.getSalary()+" "+v.getAge()));

	}

}
