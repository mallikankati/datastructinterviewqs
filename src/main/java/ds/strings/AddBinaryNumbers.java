package ds.strings;

import java.util.logging.Logger;

public class AddBinaryNumbers {
	private static final Logger logger = Logger
			.getLogger(AddBinaryNumbers.class.getName());

	// Q11: Add binary strings
	// Ex: "11" + "1" = "100"
	public static String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (i >= 0 || j >= 0) {
			int sum = 0;
			if (i >= 0 && a.charAt(i) == '1') {
				sum++;
			}
			if (j >= 0 && b.charAt(j) == '1') {
				sum++;
			}
			sum += carry;
			if (sum >= 2) {
				carry = 1;
			} else {
				carry = 0;
			}
			sb.insert(0, (char) ((sum % 2) + '0'));
			i--;
			j--;
		}
		if (carry == 1) {
			sb.insert(0, '1');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// Q11
		logger.info("add binary 11 + 1:" + addBinary("11", "1"));
		logger.info("add binary 11 + 11:" + addBinary("11", "11"));
		logger.info("add binary 100 + 11:" + addBinary("100", "11"));
		logger.info("add binary 110 + 11:" + addBinary("110", "11"));
	}
}
