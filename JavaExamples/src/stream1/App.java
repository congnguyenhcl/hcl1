package stream1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person1 {
	String n, p, e;

	Person1(String n, String p, String e) {
		this.n = n; // name
		this.p = p; // phone
		this.e = e;// email

	}

	public String getN() {
		return n;
	}

	public String getP() {
		return p;
	}

	public String getE() {
		return e;
	}

	public void setN(String n) {
		this.n = n;
	}

	public void setP(String p) {
		this.p = p;
	}

	public void setE(String e) {
		this.e = e;
	}

	@Override
	public String toString() {
		return "Person1 [n=" + n + ", p=" + p + ", e=" + e + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(n, p);

	}

	@Override
	public boolean equals(Object o) {
		Person1 person = (Person1) o;
		return person.n.equalsIgnoreCase(n) && person.p.equalsIgnoreCase(p);

	}
}

class Person2 {
	String n, p;

	Person2(String n, String p) {
		this.n = n; // name
		this.p = p; // phone
	}

	@Override
	public String toString() {
		return "Person2 [name=" + n + ", phone=" + p + "]";
	}

	// Must override hashcode and equals for Collectors.toSet() to work
	@Override
	public int hashCode() {
		return Objects.hash(n, p);

	}

	@Override
	public boolean equals(Object o) {
		Person2 person = (Person2) o;
		return person.n.equalsIgnoreCase(n) && person.p.equalsIgnoreCase(p);

	}

}

public class App {
	/*
	 * A stream operation can be either terminal or intermediate.
	 * 
	 * A terminal operation consumes the stream and cannot be reused. You have to
	 * obtain a new stream afterward.
	 * 
	 * An intermediate operation does not execute immediately but instead performed
	 * on the new stream created by the intermediate operation when a terminal
	 * operation is performed.
	 */
	public static void main(String[] args) {
		List<Integer> IntegerList = Arrays.asList(5, 2, 1, 3, 9, 10);

		// Obtain a stream of Integer from the List<Integer>. This can be done for all
		// Collection sublclasses and interfaces
		Stream<Integer> IntegerStream = IntegerList.stream();

		// stream().min is a terminal operation that returns an Optional type value
		Optional<Integer> minValue = IntegerStream.min(Integer::compare);
		System.out.println("Min value is " + minValue.get());
		System.out.println();

		// stream().max is also a terminal operation thus we need to obtain a new stream
		IntegerStream = IntegerList.stream();
		Optional<Integer> maxValue = IntegerStream.max(Integer::compare);
		System.out.println("Max value is " + maxValue.get()); // get() is a method of the Optional class that returns a
																// value
		System.out.println();

		// The sorted() methods (intermediate operation) return a sorted stream
		IntegerStream = IntegerList.stream();
		Stream<Integer> IntegerListSorted = IntegerStream.sorted();
		System.out.println("Sorted list as a stream");
		IntegerListSorted.forEach((value) -> System.out.print(value + " ")); // forEach is a terminal operation
		System.out.println();

		// Obtain odd values
		Predicate<Integer> odd = (n) -> (n % 2) == 1;
		Predicate<Integer> greaterThanFive = (n) -> (n > 5);
		Stream<Integer> oddValue = IntegerList.stream().sorted().filter(odd);
		// You can also combine those 2 lines into one
//		Stream<Integer> oddValue = IntegerList.stream().sorted().filter((n) -> (n%2) ==1);
		System.out.println("Odd values as a stream");
		oddValue.forEach(value -> System.out.print(value + " "));

		System.out.println();
		System.out.println("Greater than five as stream");
		Stream<Integer> greaterThanFiveValue = IntegerList.stream().sorted().filter(greaterThanFive);
		greaterThanFiveValue.forEach(value -> System.out.print(value + " "));

		System.out.println();
		/*
		 * Reduce function
		 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
		 * 
		 * Stream has three reduce methods:
		 * 
		 * 1- Optional<T> reduce(BinaryOperator<T> accumulator) 2- T reduce(T
		 * identity,BinaryOperator<T> accumulator) 3- <U> U reduce(U
		 * identity,BiFunction<U,T,U> accumulator,BinaryOperator<U> combiner)
		 * 
		 * The reduce operation in this example takes two arguments:
		 * 
		 * identity: The identity element is both the initial value of the reduction and
		 * the default result if there are no elements in the stream. In this example,
		 * the identity element is 0; this is the initial value of the sum of ages and
		 * the default value if no members exist in the collection roster.
		 * 
		 * For sum operation, the identity is 0. For multiplication, the identity is 1.
		 * 
		 * accumulator: The accumulator function takes two parameters: a partial result
		 * of the reduction (in this example, the sum of all processed integers so far)
		 * and the next element of the stream (in this example, an integer). It returns
		 * a new partial result. In this example, the accumulator function is a lambda
		 * expression that adds two Integer values and returns an Integer value:
		 * 
		 * (a, b) -> a + b
		 * 
		 * 
		 * It is important to understand that the accumulator operation must satisfy
		 * three constraints. It must be
		 * 
		 * Stateless
		 * 
		 * Non-interfering
		 * 
		 * Associative
		 * 
		 * As explained earlier, stateless means that the operation does not rely on any
		 * state information. Thus, each element is processed independently.
		 * Non-interfering means that the data source is not modified by the operation.
		 * Finally, the operation must be associative. Here, the term associative is
		 * used in its normal, arithmetic sense, which means that, given an associative
		 * operator used in a sequence of operations, it does not matter which pair of
		 * operands are processed first. For example,
		 * 
		 * (10 * 2) * 7
		 * 
		 * yields the same result as
		 * 
		 * 10 * (2 * 7)
		 * 
		 * Associativity is of particular importance to the use of reduction operations
		 * on parallel streams
		 */

		// Product of all numbers in the list
		List<Double> DoubleList = Arrays.asList(5.0);

		// Method 1 - Return the result as an Optional type
		Optional<Double> DoubleListMultiplyStream = DoubleList.stream().reduce((a, b) -> a * b);
		if (DoubleListMultiplyStream.isPresent())
			System.out.println("Product as Optional: " + DoubleListMultiplyStream.get());
		// Method 2 - Return the result as a double type because IdentityVal is used
		double DoubleListProduct = DoubleList.stream().reduce(1.0, (a, b) -> a * b);
		System.out.println("Product as double: " + DoubleListProduct);

		/*
		 * Using parallelStream()
		 */
		System.out.println("Using parallelStream()");
		Optional<Double> DoubleListMultiplyParallelStream = DoubleList.parallelStream().reduce((a, b) -> a * b);
		if (DoubleListMultiplyParallelStream.isPresent())
			System.out.println("Product as Optional: " + DoubleListMultiplyParallelStream.get());

		// Using different combiner for parallelStream()
		List<Double> DoubleList2 = Arrays.asList(1.0, 2.0, 3.0, 4.0);
		System.out.println("parallelStream() with different combiner");
		System.out.println(DoubleList2.stream().reduce(5.0, Double::sum)); // produces 15
		// Does not produce 15 because in parallel, each thread adds 5 to the result
		System.out.println(DoubleList2.parallelStream().reduce(5.0, Double::sum));//
		// Produces 15
		System.out.println(DoubleList2.parallelStream().reduce(0.0, Double::sum) + 5.0);

		/*
		 * <R> Stream<R> map(Function<? super T, ? extends R> mapFunc) R is the return
		 * type of the returning stream T is the type of the object invoking the map()
		 * and mapFunc() is an instance of Function
		 * 
		 * The map function must be stateless and non-interfering
		 * 
		 * Function<T,R> is a functional interface that has the method R apply(T val)
		 * where val is a reference to the object being mapped.
		 * 
		 * Other versions of map()
		 * 
		 * IntStream mapToInt(ToIntFunction<? super T> mapFunc)
		 * 
		 * LongStream mapToLong(ToLongFunction<? super T> mapFunc)
		 * 
		 * DoubleStream mapToDouble(ToDoubleFunction<? super T> mapFunc)
		 * 
		 */

		List<Person1> p1 = Arrays.asList(new Person1("bob", "123", "bob@gmail.com"),
				new Person1("bob", "123", "bob@gmail.com"), new Person1("sue", "456", "sue@yahoo.com"),
				new Person1("tom", "789", "tom@usa.gov"), new Person1("tom", "789", "tom@usa.gov"));
		List<Person2> p2 = new ArrayList();
		Stream<Person2> p2Stream = p2.stream();
		p2Stream = p1.stream().map(person1Object -> new Person2(person1Object.getN(), person1Object.getP()));
		p2Stream.forEach(v -> System.out.println(v));
		System.out.println();
		// Primitive mapping
		List<Integer> li1 = Arrays.asList(1, 2, 3, 4, 5);
		li1.stream().mapToDouble(v -> v).forEach(v -> System.out.print(v + " "));
		System.out.println();
		li1.stream().mapToLong(v -> v).forEach(v -> System.out.print(v + " "));

		/*
		 * <R, A> R collect(Collector<? super T, A, R> collectorFunc)
		 * 
		 * This method converts a stream into other type such as an ArrayList, List,
		 * Set, or LinkedList
		 * 
		 * Here, R specifies the type of the result, and T specifies the element type of
		 * the invoking stream. The internal accumulated type is specified by A. The
		 * collectorFunc specifies how the collection process works. The collect( )
		 * method is a terminal operation.
		 */
		System.out.println();
		System.out.println("collect method");

		// collect and convert the stream into a list
		System.out.println("Collectors.toList()");
		List<Person2> p21 = p1.stream().map(person1Object -> new Person2(person1Object.getN(), person1Object.getP()))
				.collect(Collectors.toList());
		p21.forEach(v -> System.out.println(v));
		System.out.println();

		// collect and convert the stream into a set
		System.out.println("Collectors.toSet() using built-in method");
		Set<Person2> p22 = p1.stream().map(person1Object -> new Person2(person1Object.getN(), person1Object.getP()))
				.collect(Collectors.toSet());
		p22.forEach(v -> System.out.println(v));

		// collect and add into a LinkedList. This manual method does not convert the
		// stream, it simply adds it
		System.out.println();
		System.out.println("collect and add to LinkedList");
		LinkedList<Person1> p11 = p1.stream().collect(() -> new LinkedList<Person1>(),
				(list, element) -> list.add(element), (listA, listB) -> listA.addAll(listB));
		for (int i = 0; i < p11.size(); i++) {
			System.out.println(p11.get(i).getN() + " " + p11.get(i).getP());
		}
		System.out.println();
		System.out.println("Collectors.toSet() using lambda");
		HashSet<Person1> p12 = p1.stream().collect(() -> new HashSet<Person1>(), (set, element) -> set.add(element),
				(setA, setB) -> setA.addAll(setB));
		p12.forEach(v -> System.out.println(v));

		// Iterate over a stream using iterator
		System.out.println();
		System.out.println("Iterate over a stream using Iterator");
		Iterator<Person1> Person1StreamIterator = p1.stream().iterator();
		while (Person1StreamIterator.hasNext()) {
			System.out.println(Person1StreamIterator.next().toString());
		}
		/*
		 * tryAdvance() performs an action on the next element and then advances the
		 * iterator As long as tryAdvance( ) returns true, the action is applied to the
		 * next element. When tryAdvance( ) returns false, the iteration is complete.
		 * Notice how tryAdvance( ) consolidates the purposes of hasNext( ) and next( )
		 * provided by Iterator into a single method.
		 */
		// Iterate over a stream using spliterator
		System.out.println();
		System.out.println("Iterate over a stream using spliterator tryAdvance()");
		Spliterator<Person1> Person1StreamSpliterator = p1.stream().spliterator();
		while (Person1StreamSpliterator.tryAdvance(element -> System.out.println(element)))
			;

		/*
		 * trySplit()
		 */

		System.out.println();
		System.out.println("Iterate over a stream using spliterator trySplit()");
		Spliterator<Person1> Person1StreamSpliterator2 = p1.stream().spliterator();
		Spliterator<Person1> Person1StreamSpliterator2TrySplit = Person1StreamSpliterator2.trySplit();
		while (Person1StreamSpliterator2.tryAdvance(element -> System.out.println(element)))
			;
		System.out.println();
		while (Person1StreamSpliterator2TrySplit.tryAdvance(element -> System.out.println(element)));
			
	}

}
