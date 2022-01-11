package lambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* A lambda function does not execute on its own. 
 * Instead, it is used to implement a method defined by a functional interface
 */

/*
 * interface i1 is a functional interface because it has one and only one abstract method
 * Its abstract method takes no argument and return an int value
 */
interface i1 {
	int getNum();
}

// i2 abstract method takes one int and returns a boolean result
interface i2 {
	boolean isEven(int i);
}

interface i3 {
	int factorial(int n);
}

/*
 * This is a generic functional interface where the return type can be of any
 * type
 */
interface i4<T> {
	T getNum();
}

interface i5 {
	String getString();
}

class i5Test {
	static String combine(i5 i, String s) {
		return i.getString() + " " + s;

	}
}

interface i6<T> {
	T getDivision(T t) throws ArithmeticException;
}

interface i7<T extends Number>{
	T getNum();
}
class C1 {
	int k = 1;

	// Get value of int i and multiply by i2
	public static int c1Method1(i1 i, int i2) {
		return i.getNum() * i2;
	}

	public int c1Method2(i1 i, int i2) {
		return i.getNum() * i2 * k;
	}

	public static int similarToi1Method() {
		return 100;
	}
	
	public static double similarToi1Method2() {
		return 100.0;
	}
	
	public static float similarToi1Method3() {
		return 100.0f;
	}
	

	
	public <T extends Number> double c1Method3(i7 i, T i2) {
		return i.getNum().doubleValue() * i2.doubleValue();
	}
}


public class LambdaDemo1 {

	public static void main(String[] args) throws Exception {

		/*
		 * The lambda expression () -> 123 provides no argument and return and integer
		 * matches the function descriptor of i1 method Thus this lambda expression
		 * provides the implementation for the said i1 abstract method When getNum() is
		 * called, the method returns an int of 123
		 */
		i1 i1 = () -> 123;
//		Supplier i1 = () -> 123;
		System.out.println(i1.getNum());
		/*
		 * This lambda expression takes one int number and perform and an equal
		 * evaluation of the number's modulus operation with 0 It matches the function
		 * description of i2 method thus providing the implementation for it. Note that
		 * you can either explicitly specify the type of n or not. Either way, Java
		 * implicitly infers the type of n is of an int
		 */
		i2 i2 = (int n) -> n % 2 == 0;
		System.out.println(i2.isEven(2));

		/*
		 * This lambda expression is called a block lambda because it has multiple
		 * lines. Hence it must be enclosed in curly braces
		 */
		i3 i3 = (n) -> {
			int result = 1;

			for (int i = 1; i <= n; i++)
				result = i * result;

			return result;
		};

		System.out.println("The factoral of 3 is " + i3.factorial(3));
		System.out.println("The factoral of 5 is " + i3.factorial(5));
		/*
		 * i1 functional interface only works with int type. Hence the below code will
		 * not compile i1 i1 = () -> 123.45; However by declaring i4 as a generic
		 * functional interface, any type of input can be returned. here we return an
		 * int, a double, a String, a float, an object type Integer, and an ArrayList
		 */
		i4 i4 = () -> 123;
		i4 i41 = () -> 123.45;
		i4 i42 = () -> "A String";
		i4 i43 = () -> 123.45f;
		i4 i44 = () -> (Integer) 10;
		i4 i45 = () -> Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(i4.getNum());
		System.out.println(i41.getNum());
		System.out.println(i42.getNum());
		System.out.println(i43.getNum());
		System.out.println(i44.getNum().getClass());
		System.out.println(i45.getNum());

		// Passing lambda as argument
		/*
		 * The combine() method takes 2 arguments, first is the argument that is of
		 * functional interface type of i5 and second is another String. This first
		 * argument is passed in using lambda expression of () -> "Hello"
		 */
		System.out.println(i5Test.combine(() -> "Hello", "Java"));

		// Lambda exception

		i6<Integer> i6 = (n) -> n / 0;
		try {
			System.out.println(i6.getDivision(0));
		} catch (Exception e) {
			System.out.println(e);
		}
		/*
		 * Variables defined by the enclosing scope of a lambda expression are
		 * accessible within the lambda expression. For example, a lambda expression can
		 * use an instance or static variable defined by its enclosing class. A lambda
		 * expression also has access to this (both explicitly and implicitly), which
		 * refers to the invoking instance of the lambda expression’s enclosing class.
		 * 
		 * Thus, a lambda expression can obtain or set the value of an instance or
		 * static variable and call a method defined by its enclosing class. However,
		 * when a lambda expression uses a local variable from its enclosing scope, a
		 * special situation is created that is referred to as a variable capture. In
		 * this case, a lambda expression may only use local variables that are
		 * effectively final. An effectively final variable is one whose value does not
		 * change after it is first assigned. There is no need to explicitly declare
		 * such a variable as final, although doing so would not be an error. (The this
		 * parameter of an enclosing scope is automatically effectively final, and
		 * lambda expressions do not have a this of their own.)
		 * 
		 * It is important to understand that a local variable of the enclosing scope
		 * cannot be modified by the lambda expression. Doing so would remove its
		 * effectively final status, thus rendering it illegal for capture.
		 */

		int foo = 20;
		i1 i11 = () -> {
			int i = 10 + foo;
			// foo++; illegal because modifying foo will render it non-effectively final
			return i;
		};
		System.out.println(i11.getNum());

		/*
		 * Lambda and Method Reference
		 * 
		 * Method reference and passing lambda as argument is related in a sense that
		 * when passing a lambda expression as argument, you can simply pass a method
		 * reference in its stead. This method can be anything as long as it is
		 * compatible with the lambda expression that implements a functional interface
		 * method. This means this method must has the same signature that includes
		 * method parameters and return type
		 * 
		 * 
		 */
		// 
		// ----Type 1 - Method Reference to static Methods
		// Method Reference convention => ClassName::methodName

		// Both i1 abstract method getNum() and C1 similarToi1Method() both return an
		// int and takes in no argument
		// Here we implement i1 method using lambda expression by returning an int value
		// of 300
		System.out.println(C1.c1Method1(() -> 300, 2));

		// Here we pass C1 method as an argument which has an int value of 100
		System.out.println(C1.c1Method1(C1::similarToi1Method, 2));

		// ----Type 2 - Method Reference to instance method
		// Method Reference convention => ClassName::instanceMethodName
		C1 c1 = new C1();
		c1.k = 5;
		// instance c1 of C1 assign 5 to variable k
		System.out.println();
		System.out.println("Method Reference to instance method");
		System.out.println(c1.c1Method2(C1::similarToi1Method, 2));
		
		// ----Type 3 - Method Reference to generic method
		// Method Reference convention => ClassName::instanceMethodName
		System.out.println();
		System.out.println("Method Reference to generic method");
		System.out.println(c1.c1Method3(C1::similarToi1Method, 2.5));//i7 is a generic interface that now can return an int
		System.out.println(c1.c1Method3(C1::similarToi1Method2, 2.5));//i7 is a generic interface that now can return a double
		System.out.println(c1.c1Method3(C1::similarToi1Method3, 2.5));//i7 is a generic interface that now can return a float
	}

}
