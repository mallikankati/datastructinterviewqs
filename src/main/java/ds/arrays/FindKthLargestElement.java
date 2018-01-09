package ds.arrays;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Logger;

public class FindKthLargestElement {
	private static final Logger logger = Logger
			.getLogger(FindKthLargestElement.class.getName());

	// Q3: Kth largest element in the array
	// Ex:[3, 10, 5, 6, 4, 7] 2nd largest should be 7 and 3rd largest should be
	// 6
	public static int findKthLargestElement(int[] arr, int k) {
		int result = 0;
		Queue<Integer> pq = new PriorityQueue<>(k);
		for (int i : arr) {
			pq.offer(i);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		result = pq.peek();
		return result;
	}

	public static void main(String[] args) {
		// Q3
		int[] arrs = { 3, 5, 10, 6, 4, 1 };
		logger.info("Q3 Kth largest:" + findKthLargestElement(arrs, 2));
	}
}
