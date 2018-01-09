package ds.strings;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class LengthOfLongestSubstringNoRepeat {

	private static final Logger logger = Logger
			.getLogger(LengthOfLongestSubstringNoRepeat.class.getName());

	// Q12: Find longest substring in a given string without repeating
	// characters
	// Ex: "abcabcbb" it should be "abc" with length 3
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int start = 0;
		Set<Character> set = new LinkedHashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				set.add(c);
				max = Math.max(max, i - start + 1);
			} else {
				for (int j = start; j < i; j++) {
					set.remove(s.charAt(j));
					if (s.charAt(j) == c) {
						start = j + 1;
						break;
					}
				}
				set.add(c);
			}
		}
		// logger.info("string :" + set);
		return max;
	}

	public static void main(String[] args) {
		// Q12
		logger.info("length of longest substring 'abcabcbb' :"
				+ lengthOfLongestSubstring("abcabcbb"));
		logger.info("length of longest substring 'bbbb' :"
				+ lengthOfLongestSubstring("bbbb"));
		logger.info("length of longest substring 'abcadeftgh' :"
				+ lengthOfLongestSubstring("abcadeftgh"));
	}
}
