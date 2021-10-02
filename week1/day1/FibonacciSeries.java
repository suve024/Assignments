package week1.day1;

public class FibonacciSeries {

	public static void main(String[] args) {
		int firstNum = 0, secNum = 1, sum, i, count = 8;
		for (i = 1; i <= count; i++) {
			System.out.println(firstNum);
			sum = firstNum + secNum;
			firstNum = secNum;
			secNum = sum;
		}
	}

}
