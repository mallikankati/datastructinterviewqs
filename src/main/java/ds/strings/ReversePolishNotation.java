package ds.strings;

import java.util.Stack;
import java.util.logging.Logger;

public class ReversePolishNotation {
	private static final Logger logger = Logger
			.getLogger(ReversePolishNotation.class.getName());

	// Q3: Evaluate and find the value of reverse polish notation with +, -, *
	// and /
	// Ex: "2 3 + 3 *" should be 15, "4 13 5 / +" should be 6.6
	public static double evaluateReversePolishNotation(String exp) {
		double result = 0;
		Stack<Double> s = new Stack<>();
		if (exp != null && exp.trim().length() > 0) {
			for (char c : exp.toCharArray()) {
				if (c == ' ') {
					continue;
				} else if (!(c == '+' || c == '-' || c == '*' || c == '/')) {
					s.push((double) (c - 48));
				} else {
					if (s.size() < 2) {
						throw new RuntimeException("Invalid expression");
					}
					Double v1 = s.pop();
					Double v2 = s.pop();
					switch (c) {
					case '+':
						s.push(v1 + v2);
						break;
					case '-':
						s.push(v1 - v2);
						break;
					case '*':
						s.push(v1 * v2);
						break;
					case '/':
						s.push((double)(v1 / v2));
						break;
					default:
						break;
					}
				}
			}
			result = s.pop();
		}
		return result;
	}

	public static void main(String[] args) {
		// Q3
		logger.info("Reverse Polish Notaion:"
				+ evaluateReversePolishNotation("2 3 + 3 *"));
		logger.info("Reverse Polish Notaion:"
				+ evaluateReversePolishNotation("4 13 5 / +"));
	}
}
