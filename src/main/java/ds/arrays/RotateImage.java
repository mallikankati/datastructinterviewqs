package ds.arrays;

import java.util.Arrays;

public class RotateImage {
	// You are given an n x n 2D matrix representing an image.
	// Rotate the image by 90 degrees (clockwise).
	// Note:You have to rotate the image in-place

	// Given input matrix = [[1,2,3],[4,5,6],[7,8,9]],
	// rotate the input matrix in-place such that it
	// becomes:[[7,4,1],[8,5,2],[9,6,3]]
	public static void rotate(int[][] matrix) {
		clockwise(matrix);
	}

	public static void clockwise(int[][] matrix) {
		int s = 0, e = matrix.length - 1;
		while (s < e) {
			int[] temp = matrix[s];
			matrix[s] = matrix[e];
			matrix[e] = temp;
			s++;
			e--;
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(Arrays.toString(matrix[i]));
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void counterclockwise(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0, k = matrix[0].length - 1; j < k; j++, k--) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = temp;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(Arrays.toString(matrix[i]));
		}
		System.out.println();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(Arrays.toString(matrix[i]));
		}
		System.out.println();
		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		counterclockwise(matrix);
		for (int i = 0; i < matrix.length; i++) {
			System.out.print(Arrays.toString(matrix[i]));
		}
		System.out.println();
	}
}
