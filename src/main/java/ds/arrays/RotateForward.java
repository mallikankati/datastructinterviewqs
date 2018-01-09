package ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class RotateForward {

	private static final Logger logger = Logger.getLogger(RotateForward.class
			.getName());

	// Q2: rotate forward
	// Ex:A : [1 2 3 4 5 6], B : 1 then it should be [2 3 4 5 6 1]
	public static List<Integer> rotateArray(List<Integer> A, int B) {
		List<Integer> ret = new ArrayList<Integer>();
		int j = 0;
		int k = 0;
		int gap = B;
		if (B > A.size()) {
			gap = gap - A.size();
			while (gap > A.size()) {
				gap = gap - A.size();
			}
		}
		// logger.info("A.size() =" + A.size() + ", gap=" + gap);
		for (int i = 0; i < A.size(); i++) {
			k = i + gap;
			if (k > (A.size() - 1)) {
				k = j++;
			}
			ret.add(A.get(k));
		}
		return ret;
	}

	public static void main(String[] args) {
		// Q2
		// List<Integer> list = Arrays.asList(44, 41, 12, 42, 71, 45, 28, 65,
		// 75);
		// logger.info(rotateArray(list, 3) + "");
		List<Integer> list = Arrays.asList(44, 41, 12, 42, 71, 45, 28, 65, 75,
				93, 66, 66, 37, 6, 24, 59);
		logger.info("Q2 rotate forward:" + rotateArray(list, 56) + "");

	}
}
