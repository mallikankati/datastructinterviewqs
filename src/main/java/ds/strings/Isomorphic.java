package ds.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Isomorphic {
	private static final Logger logger = Logger.getLogger(Isomorphic.class
			.getName());

	// Q4: Is given string Isomorphic
	// Ex: "egg" and "add" is Isomorphic but "foo" and "bar" is not
	public static boolean isIsomorphic(String s, String t) {
		if ((s == null || t == null) || (s.length() != t.length())) {
			return false;
		}
		if (s == "" && t == "") {
			return true;
		}
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char d = t.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) != d) {
					return false;
				}
			} else {
				if (!map.containsValue(d)) {
					map.put(c, d);
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// Q4
		logger.info("Isomorphic:" + isIsomorphic("egg", "add"));
		// logger.info("Isomorphic:" + isIsomorphic("aba", "baa"));

	}
}
