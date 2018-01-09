package ds.strings;

import java.util.logging.Logger;

public class ParseInt {
	private static final Logger logger = Logger.getLogger(ParseInt.class
			.getName());

	// Q2: Convert string to integer
	public static int parseInt(String str) {
		if (str == null || str.trim().length() <= 0) {
			return 0;
		}
		str = str.trim();
		int result = 0;
		int startIndex = 0;
		boolean sign = false;
		if (str.charAt(0) == '-') {
			sign = true;
			startIndex = 1;
		}
		if (str.charAt(0) == '+') {
			startIndex = 1;
		}
		for (int i = startIndex; i < str.length(); ++i) {
			if (!Character.isDigit(str.charAt(i))) {
				break;
			}
			int digit = str.charAt(i) - '0';
			result *= 10;
			if ((result + digit) > Integer.MAX_VALUE
					|| (result + digit) <= Integer.MIN_VALUE) {
				if (sign) {
					return Integer.MIN_VALUE;
				} else {
					result = Integer.MAX_VALUE;
				}
				break;
			}
			result += digit;
		}

		return sign ? -result : result;
	}

	public static void main(String[] args) {
		// Q2
		logger.info("Q2 parse int:" + parseInt("-2147483649"));
		logger.info("Q2 parse int:" + parseInt("2147483648"));
		logger.info("Q2 parse int:" + parseInt("-2147483648"));
		logger.info("Q2 parse int:" + parseInt("-2147483647"));
		logger.info("Q2 parse int:" + parseInt("11111"));
		logger.info("Q2 parse int:" + parseInt("-231"));
		logger.info("Q2 parse int:" + parseInt("+1"));
		logger.info("Q2 parse int:" + parseInt(""));
		logger.info("Q2 parse int:" + parseInt("+-2"));
		logger.info("Q2 parse int:" + parseInt(" 020"));
		logger.info("Q2 parse int:" + parseInt(" -0012a42"));
	}
}
