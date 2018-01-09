package ds.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TestArray {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(TestArray.class
			.getName());

	static ArrayList<Integer> performOps(List<Integer> A) {
		ArrayList<Integer> B = new ArrayList<Integer>();
		for (int i = 0; i < 2 * A.size(); i++)
			B.add(0);
		for (int i = 0; i < A.size(); i++) {
			B.set(i, A.get(i));
			B.set(i + A.size(), A.get((A.size() - i) % A.size()));
		}
		return B;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 10, 2, 1);
		ArrayList<Integer> B = performOps(list);
		for (int i = 0; i < B.size(); i++) {
			System.out.print(B.get(i) + " ");
		}
		System.out.println();
		String s = "123";
		for (char c : s.toCharArray()) {
			System.out.println(c - '0');
		}
	}
}
