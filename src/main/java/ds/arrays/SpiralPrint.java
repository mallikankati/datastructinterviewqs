package ds.arrays;

import java.util.Arrays;
import java.util.logging.Logger;

public class SpiralPrint {
	private static final Logger logger = Logger.getLogger(SpiralPrint.class
			.getName());

	// Q4: Spiral print array
	// Ex:[[1, 2, 3], [4, 5,6], [7,8,9]] it should be [1, 2, 3, 6, 9, 8, 7, 4,
	// 5]
	public static int[] spiralPrint(int[][] arr) {
		int[] result = new int[arr.length * arr[0].length];
		logger.info("array length:" + arr.length + ", col:" + arr[0].length);
		int row_s = 0, row_e = arr.length, col_s = 0, col_e = arr[0].length;
		int k = 0;
		while (row_s < row_e && col_s < col_e) {
			for (int i = col_s; i < col_e; i++) {
				result[k++] = arr[row_s][i];
			}
			row_s++;
			for (int i = row_s; i < row_e; i++) {
				result[k++] = arr[i][col_e - 1];
			}
			col_e--;
			if (row_s < row_e) {
				for (int i = col_e - 1; i >= col_s; i--) {
					result[k++] = arr[row_e - 1][i];
				}
				row_e--;
			}
			if (col_s < col_e) {
				for (int i = row_e - 1; i >= row_s; i--) {
					result[k++] = arr[i][col_s];
				}
				col_s++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// Q4
		// int[][] arr2d = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr2d = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } };
		logger.info("Q4 Spiral print:" + Arrays.toString(spiralPrint(arr2d))
				+ "");
	}
}
