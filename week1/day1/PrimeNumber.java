package week1.day1;

public class PrimeNumber {

	public static void main(String[] args) {
		int num = 13;
		boolean flag = false;
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("Prime Number");
		} else {
			System.out.println("Not a prime Number");
		}

	}

}
