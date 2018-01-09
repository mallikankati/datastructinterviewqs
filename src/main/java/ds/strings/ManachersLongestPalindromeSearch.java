package ds.strings;

import java.util.logging.Logger;

public class ManachersLongestPalindromeSearch {
	private static final Logger logger = Logger
			.getLogger(ManachersLongestPalindromeSearch.class.getName());

	// Q10: Longest palindromic substring in linear time (Manacher's algorithm)
	public static int longestPalindromicSubstringLinear(String str) {
		// preprocess string convert to handle even length case abc -> $a$b$c
		char[] newInput = new char[2 * str.length() + 1];
		int index = 0;
		for (int i = 0; i < newInput.length; i++) {
			if (i % 2 != 0) {
				newInput[i] = str.charAt(index++);
			} else {
				newInput[i] = '$';
			}
		}
		int[] T = new int[newInput.length];
		int start = 0, end = 0;
		// expand around i. See how far we can go.
		for (int i = 0; i < newInput.length;) {
			while (start > 0 && end < newInput.length - 1
					&& newInput[start - 1] == newInput[end - 1]) {
				start--;
				end++;
			}
			// set the longest value of palindrome around center i at T[i]
			T[i] = end - start + 1;

			// this is case 2. Current palindrome is proper suffix of input. No
			// need to proceed. Just break out of loop.
			if (end == T.length - 1) {
				break;
			}

			// Mark newCenter to be either end or end + 1 depending on if we
			// dealing with even or odd number input.
			int newCenter = end + (i % 2 == 0 ? 1 : 0);

			for (int j = i + 1; j <= end; j++) {
				// i - (j - i) is left mirror. Its possible left mirror might go
				// beyond current center palindrome. So take minimum
				// of either left side palindrome or distance of j to end.
				T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
				// Only proceed if we get case 3. This check is to make sure we
				// do not pick j as new center for case 1 or case 4
				// As soon as we find a center lets break out of this inner
				// while loop.
				if (j + T[i - (j - i)] / 2 == end) {
					newCenter = j;
					break;
				}
			}
			// make i as newCenter. Set right and left to atleast the value we
			// already know should be matching based of left side palindrome.
			i = newCenter;
			end = i + T[i] / 2;
			start = i - T[i] / 2;
		}

		// find the max palindrome in T and return it.
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < T.length; i++) {
			if (max < T[i] / 2) {
				max = T[i] / 2;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// Q10
		logger.info("longest palindrome abba:"
				+ longestPalindromicSubstringLinear("abba"));
		logger.info("longest palindrome abbababba:"
				+ longestPalindromicSubstringLinear("abbababba"));
		logger.info("longest palindrome babcbaabcbaccba:"
				+ longestPalindromicSubstringLinear("babcbaabcbaccba"));
		logger.info("longest palindrome cdbabcbabdab:"
				+ longestPalindromicSubstringLinear("cdbabcbabdab"));
	}
}
