package ds.ints;

public class IntegerToEnglishWord {

	private static String[] NUM_LESS_20 = { "", "One", "Two", "Three", "Four",
			"Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
			"Tweleve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
			"Seventeen", "Eighteen", "Nineteen" };

	private static String[] NUM_10S = { "", "Ten", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };

	private static String[] NUM_1000S = { "", "Thousands ", "Millions ",
			"Billions " };

	// Convert a non-negative integer to its english words representation. Given
	// input is guaranteed to be less than 2^31 - 1.
	public static String numberToWords(int num) {
		if (num <= 0) {
			return "Zero";
		}
		String words ="";
		int i = 0;
		while (num > 0) {
			if (num % 1000 != 0) {
				words = helper(num % 1000) + " " + NUM_1000S[i]
						+ words;
			} else {
				//sb.append(helper(num));
			}
			num /= 1000;
			i++;
		}
		return words.trim();
	}

	private static String helper(int num) {
		if (num == 0) {
			return "";
		} else if (num < 20) {
			return NUM_LESS_20[num] + " ";
		} else if (num < 100) {
			return NUM_10S[num / 10] + " " + helper(num % 10);
		} else {
			return NUM_LESS_20[num / 100] + " Hundred " + helper(num % 100);
		}
	}

	public static void main(String[] args) {
		System.out.println("1 ->" + numberToWords(1));
		System.out.println("12 ->" + numberToWords(12));
		System.out.println("123 ->" + numberToWords(123));
		System.out.println("1234 ->" + numberToWords(1234));
		System.out.println("12345 ->" + numberToWords(12345));
		System.out.println("123456 ->" + numberToWords(123456));
		System.out.println("1234567 ->" + numberToWords(1234567));
		System.out.println("12345678 ->" + numberToWords(12345678));
		System.out.println("123456789 ->" + numberToWords(123456789));
		System.out.println("1234567890 ->" + numberToWords(1234567890));
	}
}
