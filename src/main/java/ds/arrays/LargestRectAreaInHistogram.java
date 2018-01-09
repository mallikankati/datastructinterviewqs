package ds.arrays;

import java.util.Stack;
import java.util.logging.Logger;

public class LargestRectAreaInHistogram {

	private static final Logger logger = Logger
			.getLogger(LargestRectAreaInHistogram.class.getName());

	// Q8: largest rectangular area in an histogram
	public static int largestRectArea(int[] height) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int p = stack.pop();
				int h = height[p];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(h * w, maxArea);
			}
		}
		while (!stack.isEmpty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.isEmpty() ? i : i - stack.peek() - 1;
			maxArea = Math.max(h * w, maxArea);
		}

		return maxArea;
	}

	public static void main(String[] args) {
		// Q8
		logger.info("Q8 largest area in histogram {2, 1, 5, 6, 2, 3} :"
				+ largestRectArea(new int[] { 2, 1, 5, 6, 2, 3 }));
		logger.info("Q8 largest area in histogram {1,2,4}:"
				+ largestRectArea(new int[] { 1, 2, 4 }));
		logger.info("Q8 largest area in histogram {2, 1, 2,3,1 }:"
				+ largestRectArea(new int[] { 2, 1, 2, 3, 1 }));
	}
}
