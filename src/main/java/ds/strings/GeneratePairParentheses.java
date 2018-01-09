package ds.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GeneratePairParentheses {
	private static final Logger logger = Logger
			.getLogger(GeneratePairParentheses.class.getName());

	// Complexity O(4**n/sqrt(n))
	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList<>();
		if (n == 0) {
			ans.add("");
		} else {
			for (int c = 0; c < n; ++c)
				for (String left : generateParenthesis(c))
					for (String right : generateParenthesis(n - 1 - c))
						ans.add("(" + left + ")" + right);
		}
		return ans;
	}

	public static void main(String[] args) {
		logger.info(generateParenthesis(3) + "");
		logger.info(generateParenthesis(4) + "");
	}
}
