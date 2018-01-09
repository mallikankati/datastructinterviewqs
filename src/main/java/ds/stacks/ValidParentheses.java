package ds.stacks;

import java.util.Stack;
import java.util.logging.Logger;

public class ValidParentheses {

	private static final Logger logger = Logger
			.getLogger(ValidParentheses.class.getName());

	public static boolean isValid(String s) {
		boolean status = true;
		if (s != null && s.trim().length() > 0) {
			s = s.trim();
			Stack<Character> stack = new Stack<>();
			for (char c : s.toCharArray()) {
				if (c == '(' || c == '[' || c == '{' || stack.isEmpty()) {
					stack.push(c);
				} else {
					char temp = stack.pop();
					if (c == ')') {
						if (temp != '(') {
							status = false;
							break;
						}
					} else if (c == ']') {
						if (temp != '[') {
							status = false;
							break;
						}
					} else if (c == '}') {
						if (temp != '{') {
							status = false;
							break;
						}
					}
				}
			}
			if (!stack.isEmpty()){
				status = false;
			}
		} else {
			status = false;
		}
		
		return status;
	}
	
	public static void main(String[] args) {
		logger.info("Test () :" + isValid("()"));
		logger.info("Test ( :" + isValid("("));
		logger.info("Test ()[ :" + isValid("()["));
		logger.info("Test ()[] :" + isValid("()[]"));
		logger.info("Test ()[()] :" + isValid("()[()]"));
		logger.info("Test ([)]:" + isValid("([)]"));
		logger.info("Test ]:" + isValid("]"));
	}
}
