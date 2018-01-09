package ds.strings;

import java.util.logging.Logger;

public class ValidPalindrome {
	private static final Logger logger = Logger.getLogger(ValidPalindrome.class
			.getName());

	// Q9: Given a string, determine if it is a palindrome, considering only
	// alphanumeric characters and ignoring cases.
	public static boolean isValidPalindrome(String s) {
		if (s == null || s.trim().length() == 0) {
			return false;
		}
		s = s.replaceAll("[^a-zA-Z0-9]", "").trim().toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// Q9
		logger.info("Valid palindrome test (A man, a plan, a canal: Panama):"
				+ isValidPalindrome("A man, a plan, a canal: Panama"));
		logger.info("Valid palindrome test (Red rum, sir, is murder):"
				+ isValidPalindrome("Red rum, sir, is murder"));
		logger.info("Valid palindrome test (Programcreek is awesome):"
				+ isValidPalindrome("Programcreek is awesome"));
	}
}
