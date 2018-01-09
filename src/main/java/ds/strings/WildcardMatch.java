package ds.strings;

import java.util.logging.Logger;

public class WildcardMatch {
	private static final Logger logger = Logger.getLogger(WildcardMatch.class
			.getName());

	// Q5: Wildcard match using '.' and '*'
	// '.' Matches any single character.
	// '*' Matches zero or more of the preceding element.
	// Ex: aab = *ab,
	public static boolean isWildcardMatch(String str, String pat) {
		// base case
		if (pat.length() == 0) {
			return str.length() == 0;
		}

		// special case
		if (pat.length() == 1 || pat.charAt(1) != '*') {
			if (str.length() < 1) {
				return false;
			} else if (str.charAt(0) != pat.charAt(0) && pat.charAt(0) != '.') {
				return false;
			} else {
				return isWildcardMatch(str.substring(1), pat.substring(1));
			}
		} else {
			// case 2.1: a char & '*' can stand for 0 element
			if (isWildcardMatch(str, pat.substring(2))) {
				return true;
			}

			// case 2.2: a char & '*' can stand for 1 or more preceding element,
			// so try every sub string
			int i = 0;
			while (i < str.length()
					&& (str.charAt(i) == pat.charAt(0) || pat.charAt(0) == '.')) {
				if (isWildcardMatch(str.substring(i + 1), pat.substring(2))) {
					return true;
				}
				i++;
			}
		}
		return false;
	}

	// Q6 Wildcard match using '?' and '*'
	public static boolean wildcardMatchWithDynamic(String str, String pat) {
		char[] strA = str.toCharArray();
		char[] patA = pat.toCharArray();
		int writeIndex = 0;
		boolean isFirst = true;
		for (int i = 0; i < pat.length(); i++) {
			if (patA[i] == '*') {
				if (isFirst) {
					patA[writeIndex++] = patA[i];
					isFirst = false;
				}
			} else {
				patA[writeIndex++] = patA[i];
				isFirst = true;
			}
		}
		boolean T[][] = new boolean[strA.length + 1][writeIndex + 1];
		T[0][0] = true;
		if (writeIndex > 0 && patA[0] == '*') {
			T[0][1] = true;
		}
		for (int i = 1; i < T.length; i++) {
			for (int j = 1; j < T[0].length; j++) {
				if (patA[j - 1] == '?' || strA[i - 1] == patA[j - 1]) {
					T[i][j] = T[i - 1][j - 1];
				} else if (patA[j - 1] == '*') {
					T[i][j] = T[i - 1][j] || T[i][j - 1];
				}
			}
		}
		return T[str.length()][writeIndex];
	}

	// greedy solution with idea of DFS for '?' and '*' wildcard match
	// starj stores the position of last * in p
	// last_match stores the position of the previous matched char in s after a
	// *
	// e.g.
	// s: a c d s c d
	// p: * c d
	// after the first match of the *, starj = 0 and last_match = 1
	// when we come to i = 3 and j = 3, we know that the previous match of * is
	// actually wrong,
	// (the first branch of DFS we take is wrong)
	// then it resets j = starj + 1
	// since we already know i = last_match will give us the wrong answer
	// so this time i = last_match+1 and we try to find a longer match of *
	// then after another match we have starj = 0 and last_match = 4, which is
	// the right solution
	// since we don't know where the right match for * ends, we need to take a
	// guess (one branch in DFS),
	// and store the information(starj and last_match) so we can always backup
	// to the last correct place and take another guess.

	public static boolean wildcardMatchWithGreedy(String s, String p) {
		int i = 0, j = 0;
		int m = s.length(), n = p.length();
		int last_match = -1, starj = -1;
		while (i < m) {
			if (j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++;
				j++;
			} else if (j < n && p.charAt(j) == '*') {
				starj = j;
				j++;
				last_match = i;
			} else if (starj != -1) {
				j = starj + 1;
				last_match++;
				i = last_match;
			} else
				return false;
		}
		while (p.charAt(j) == '*' && j < n)
			j++;
		return j == n;
	}

	public static void main(String[] args) {
		// Q5
		logger.info("recursisve wildcard .* ('aa' , 'a') ="
				+ isWildcardMatch("aa", "a"));
		logger.info("recursisve wildcard .* ('aa' , 'aa') ="
				+ isWildcardMatch("aa", "aa"));
		logger.info("recursisve wildcard .* ('aaa' , 'a') ="
				+ isWildcardMatch("aaa", "a"));
		logger.info("recursisve wildcard .* ('aa' , 'a*') ="
				+ isWildcardMatch("aa", "a*"));
		logger.info("recursisve wildcard .* ('aa' , '.*') ="
				+ isWildcardMatch("aa", ".*"));
		logger.info("recursisve wildcard .* ('abc' , '.*') ="
				+ isWildcardMatch("abc", ".*"));
		logger.info("recursisve wildcard .* ('aab' , 'c*a*b') ="
				+ isWildcardMatch("aab", "c*a*b"));

		// Q6
		logger.info("dynamic wildcard ?* ('aa' , 'a') ="
				+ wildcardMatchWithDynamic("aa", "a"));
		logger.info("dynamic wildcard ?*  ('aa' , 'aa') ="
				+ wildcardMatchWithDynamic("aa", "aa"));
		logger.info("dynamic wildcard ?*  ('aaa' , 'a') ="
				+ wildcardMatchWithDynamic("aaa", "a"));
		logger.info("dynamic wildcard ?*  ('aa' , 'a*') ="
				+ wildcardMatchWithDynamic("aa", "a*"));
		logger.info("dynamic wildcard ?*  ('aa' , '?*') ="
				+ wildcardMatchWithDynamic("aa", "?*"));
		logger.info("dynamic wildcard ?*  ('abc' , '?*') ="
				+ wildcardMatchWithDynamic("abc", "?*"));
		// TODO: Need to debug for this case, it's failing
		logger.info("dynamic wildcard ?*  ('aab' , 'c*a*b') ="
				+ wildcardMatchWithDynamic("aab", "c*a*b"));
	}
}
