package week3.day1;

public class StringComparison {

	public static void main(String[] args) {

		// To compare a given string to another string, ignoring case considerations
		String str1 = "I am Learning Java";
		String str2 = "I am learning java";

		// using comparison operator ==
		if (str1 == str2) {
			System.out.println("Strings are matched");
		} else {
			System.out.println("Strings doesn't Match");
		}

		// using equals
		if (str1.equals(str2)) {
			System.out.println("Strings are matched");
		} else {
			System.out.println("Strings doesn't match");
		}

		// using equalsIgnoreCase
		if (str1.equalsIgnoreCase(str2)) {
			System.out.println("Strings are matched");
		} else {
			System.out.println("Strings doesn't Match");
		}
	}

}
