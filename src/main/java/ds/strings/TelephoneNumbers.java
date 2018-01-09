package ds.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TelephoneNumbers {

	private static final Logger logger = Logger
			.getLogger(TelephoneNumbers.class.getName());

	// Given digit string return all the combination of letter strings
	// Ex: Input: "23", Output:["ad", "ae", "af", "bd", "be", "bf", "cd", "ce",
	// "cf"]

	public static List<String> letterCombinations(String digits) {
		String[] keyMap = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		List<String> ans = new ArrayList<>();
		if (digits != null && digits.trim().length() > 0) {
			digits = digits.trim();
			List<String> ansPrefix = new ArrayList<>();
			if (digits.length() == 1)
				ansPrefix.add("");
			else
				ansPrefix = letterCombinations(digits.substring(1));
			for (String s : ansPrefix) {
				for (char c : keyMap[digits.charAt(0) - '0'].toCharArray()) {
					ans.add(c + s);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		logger.info("Digits 23:" + letterCombinations("23"));
		logger.info("Digits 2:" + letterCombinations("2"));
		logger.info("Digits :" + letterCombinations(""));
		logger.info("Digits 234:" + letterCombinations("234"));
	}
}
