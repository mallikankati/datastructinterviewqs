package ds.ints;

import java.util.logging.Logger;

public class ReverseInt {

	private static final Logger logger = Logger.getLogger(ReverseInt.class
			.getName());

	// Reverse integer
	// Ex: input = 123, output = 321
	// Ex: input = -123, output = -321
	// Ex: input= 120, output = 21
	//Note: it fails for the input = 1534236469
	public static int reverseInt(int x) {
		if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
			return 0;
		}
		int rev = 0;
		while (x != 0) {
			if (rev >= Integer.MAX_VALUE || rev <= Integer.MIN_VALUE) {
				return 0;
			}
			rev *= 10;
			rev += x % 10;
			x = x / 10;

		}
		return rev;
	}

	public static void main(String[] args) {
		logger.info("Reverse 123 : " + reverseInt(123));
		logger.info("Reverse -123 : " + reverseInt(-123));
		logger.info("Reverse 120 : " + reverseInt(120));
		logger.info("Reverse 1534236469 :" + reverseInt(1534236469));
	}
}
