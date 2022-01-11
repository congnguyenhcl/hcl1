package generics1;

import java.util.List;

class WildCard<T extends Number> {
	T[] numArray;

	WildCard(T[] inputArray) {
		numArray = inputArray;
	}

	double avg() {
		double sum = 0.0;
		for (int i = 0; i < numArray.length; i++) {
			sum += numArray[i].doubleValue();
		}
		return sum / numArray.length;

	}

	boolean compareAvg1(WildCard<?> arrayToCompare) {
		return avg() == arrayToCompare.avg();
	}
	/*
	 * This method generates run-time error because it can only be used to
	 * compare 2 objects of the same type. The type of the object to be compared
	 * with depends on the type of the object used to invoke this method
	 * 
	 * For example: we create an object of type Integer. When this object invokes
	 * this method, the array to be compared with must also be of type Integer
	 * 
	 * boolean compareAvg1(WildCard<T> arrayToCompare) { return
	 * avg()==arrayToCompare.avg()}
	 * 
	 * 
	 */

}

public class WildCardDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arInteger = { 1, 2, 3, 4, 5 };
		Double[] arDouble = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		WildCard<Integer> wc1 = new WildCard<Integer>(arInteger);
		WildCard<Double> wc2 = new WildCard<Double>(arDouble);
		System.out.println(wc1.compareAvg1(wc2));//Generates run-time error if the method does not use wildcard generic
	}
}
