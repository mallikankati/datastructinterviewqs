package ds.arrays;

import java.util.Stack;

public class TrappingRainWater {

	// Given n non-negative integers representing an elevation map where the
	// width of each bar is 1, compute how much water it is able to trap after
	// raining.
	// For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	public static int trap(int[] height) {
		int ans = 0, current = 0;
		Stack<Integer> st = new Stack<>();
		if (height != null && height.length > 0) {
			while (current < height.length) {
				while (!st.isEmpty() && height[current] > height[st.peek()]) {
					int top = st.pop();
					if (st.empty()) {
						break;
					}
					int distance = current - st.peek() - 1;
					int bounded_height = Math.min(height[current],
							height[st.peek()])
							- height[top];
					ans += distance * bounded_height;
				}
				st.push(current++);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("[0,1,0,2,1,0,1,3,2,1,2,1] :"
				+ trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
	}
}
