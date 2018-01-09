package ds.strings;

import java.util.logging.Logger;

public class KMPSubstringSearch {
	private static final Logger logger = Logger
			.getLogger(KMPSubstringSearch.class.getName());

	// Q7: substring search in a string using KMP algorithm
	// Ex: abcxabcdabcdabcy has abcdabcy
	// Complexity O(m+n)
	public static boolean subStringSearch(String str, String pat) {
		int[] lps = computePatArray(pat);
		int i = 0, j = 0;
		while (i < str.length() && j < pat.length()) {
			if (str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pat.length()) {
			return true;
		}
		return false;
	}

	private static int[] computePatArray(String pat) {
		int[] lps = new int[pat.length()];
		int index = 0, i = 1;
		while (i < pat.length()) {
			if (pat.charAt(i) == pat.charAt(index)) {
				lps[i] = index + 1;
				i++;
				index++;
			} else {
				if (index != 0) {
					index = lps[index - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		// Q7
		logger.info("substring search with KMP 'abcxabcdabcdabcy' pat = 'abcdabcy': "
				+ subStringSearch("abcxabcdabcdabcy", "abcdabcy"));
	}
}
