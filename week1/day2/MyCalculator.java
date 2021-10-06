package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		Calculator obj = new Calculator();
		int a = obj.add(5, 7, 15);
		System.out.println("Add : " + a);
		int s = obj.sub(20, 5);
		System.out.println("Sub : " + s);
		System.out.println("Mul : " + obj.mul(a, s));
		float d = obj.divide(a, s);
		System.out.println("Div : " + d);
	}

}
