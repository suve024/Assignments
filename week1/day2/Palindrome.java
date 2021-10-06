package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		String str = "madam";
		int length = str.length();
		String rev = "";
		for (int i = length - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		if (str.equals(rev)) {
			System.out.println("Given String is a Palindrome");
		} else
			System.out.println("Given String is a Palindrome");
	}

}
