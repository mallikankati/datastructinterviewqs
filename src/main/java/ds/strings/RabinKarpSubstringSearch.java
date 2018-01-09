package ds.strings;

import java.util.logging.Logger;

public class RabinKarpSubstringSearch {
	private static final Logger logger = Logger
			.getLogger(RabinKarpSubstringSearch.class.getName());

	// Q8 : string search with Rabin Karp algorithm
	// Ex: abcxabcdabcdabcy has abcdabcy
	// complexity O(m*n)
	public static boolean rabinKarpSearch(String str, String pat) {
		int m = pat.length();
		int n = str.length();
		long patHash = createHash(pat, m - 1);
		long strHash = createHash(str, m - 1);
		for (int i = 1; i <= n - m + 1; i++) {
			if (patHash == strHash && checkEql(str, i - 1, i + m - 1, pat)) {
				return true;
			}
			if (i < n - m + 1) {
				strHash = recalculateHash(str, i - 1, i + m - 1, strHash, m);
			}
		}
		return false;
	}

	private static long createHash(String str, int end) {
		long hash = 0;
		for (int i = 0; i <= end; i++) {
			hash += str.charAt(i) * Math.pow(101, i);
		}
		return hash;
	}

	private static boolean checkEql(String str, int start, int end, String pat) {
		if (str.substring(start, end).equals(pat)) {
			return true;
		}
		return false;
	}

	private static long recalculateHash(String str, int oldIndex, int newIndex,
			long oldHash, int patLength) {
		long newHash = oldHash - str.charAt(oldIndex);
		newHash = newHash / 101;
		newHash += str.charAt(newIndex) * Math.pow(101, patLength - 1);
		return newHash;
	}

	public static void main(String[] args) {
		// Q8
		logger.info("substring search with RabinKarp 'abcxabcdabcdabcy' pat = 'abcdabcy': "
				+ rabinKarpSearch("abcxabcdabcdabcy", "abcdabcy"));
		logger.info("substring search with RabinKarp 'abcxabcdabcdabcy' pat = 'abcdabc': "
				+ rabinKarpSearch("abcxabcdabcdabcy", "abcdabc"));

	}
}
