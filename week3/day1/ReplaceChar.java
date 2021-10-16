package week3.day1;

public class ReplaceChar {

	public static void main(String[] args) {

		// To replace a specified character with another character 
		//and add # to the given string
		String sentence = "I am working with Java8";
		String replace = sentence.replaceFirst("8", "11");
		replace = replace  + '#' ;
		System.out.println(replace);
		
		//Print the characters from 5 to 14
		System.out.println(replace.substring(5, 15));

	}

}
