package ds.strings;

import java.util.logging.Logger;

public class ReverseWords {
	private static final Logger logger = Logger.getLogger(ReverseWords.class
			.getName());

	// Q1: Reverse words in a string
	// Ex: 'This is my test' should be 'test my is This'
	public static String reverseWords(String input) {
		if (input == null || input.trim().length() <= 0)
			return null;
		char[] chars = input.toCharArray();
		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				reverse(chars, j, i - 1);
				j = i + 1;
			}
		}

		reverse(chars, j, chars.length - 1);
		reverse(chars, 0, chars.length - 1);

		return new String(chars);
	}

	private static void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start++] = s[end];
			s[end--] = temp;
		}
	}

	public static void main(String[] args) {
		// Q1
		logger.info("Q1 reverse words:" + reverseWords("This is my test"));
	}
}
