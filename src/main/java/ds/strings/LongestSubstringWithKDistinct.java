package ds.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LongestSubstringWithKDistinct {
	private static final Logger logger = Logger
			.getLogger(LongestSubstringWithKDistinct.class.getName());

	// Q13: Length of longest substring with k distinct characters
	// Ex: "abcbbbbcccbdddadacb" k = 2 it should be 'bcbbbbcccb'
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (k == 0 || s == null || s.length() == 0) {
			return 0;
		}
		if (s.length() < k) {
			return s.length();
		}
		Map<Character, Integer> map = new HashMap<>();
		int max = k;
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			if (map.size() > k) {
				max = Math.max(max, i - left);
				while (map.size() > k) {
					char fc = s.charAt(left);
					if (map.get(fc) == 1) {
						map.remove(fc);
					} else {
						map.put(fc, map.get(fc) - 1);
					}
					left++;
				}
			}
		}
		max = Math.max(max, s.length() - left);
		return max;
	}

	public static void main(String[] args) {
		// Q13
		logger.info("length of longest substring with k distinct 'abcabcbb' :"
				+ lengthOfLongestSubstringKDistinct("abcabcbb", 2));
		logger.info("length of longest substring with k distinct 'abcadcacacaca' :"
				+ lengthOfLongestSubstringKDistinct("abcadcacacaca", 3));
	}
}
