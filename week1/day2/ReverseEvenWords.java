package week1.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		
		String test = "I am a software tester";
		String[] words = test.split(" ");
		
		for (int i = 0; i < words.length; i++) {
			if (i % 2 != 0) {
				char[] evenWords = words[i].toCharArray();
				for (int j = evenWords.length - 1; j >= 0; j--) {
					System.out.print(evenWords[j]);
				}
				System.out.print(" ");
			} else {
				System.out.print(words[i] + " ");
			}
		}
	}

}
