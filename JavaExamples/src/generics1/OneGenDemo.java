/*A Generic Class with 1 Type Parameters
 * 
 */


package generics1;

class OneGen<T> {
	T ob;

	public OneGen(T ob) {
		this.ob = ob;
	}

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}


}

public class OneGenDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneGen<Integer> num1 = new OneGen<Integer>(10);
		num1.setOb(20);
		System.out.println(num1.getOb());
		
		OneGen<Integer> num2 = new OneGen<Integer>(10);
		num2.setOb(20);
		System.out.println(num2.getOb());
		
		System.out.println(num1==num2);
		System.out.println(num1.getOb() ==num2.getOb());
		
	}

}
