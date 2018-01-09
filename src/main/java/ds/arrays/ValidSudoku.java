package ds.arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

	// The Sudoku board could be partially filled, where empty cells are filled
	// with the character '.'
	// Three rules to sudoku
	// 1) Each row must have the numbers 1-9 occuring just once.
	// 2) Each column must have the numbers 1-9 occuring just once.
	// 3) numbers 1-9 must occur just once in each of the 9 sub-boxes of
	// the grid.
	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			Set<Character> rows = new HashSet<>();
			Set<Character> cols = new HashSet<>();
			Set<Character> box = new HashSet<>();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && !cols.add(board[j][i])) {
					return false;
				}
				int rowIndex = 3 * (i / 3) + j / 3;
				int colIndex = 3 * (i % 3) + j % 3;
				if (board[rowIndex][colIndex] != '.'
						&& !box.add(board[rowIndex][colIndex])) {
					return false;
				}
			}
		}
		return true;
	}

	public static char[][] convert(String str) {
		char[][] board = new char[9][9];
		int i = 0, j = 0;
		for (char c : str.toCharArray()) {
			board[i][j] = c;
			if ((j + 1) % 9 == 0) {
				i++;
				j = 0;
			} else {
				j++;
			}
		}
		return board;
	}

	public static void main(String[] args) {
		String str = "53..7....6..195....98....6.8...6...34..8.3..17...2...6.6....28....419..5....8..79";
		System.out.println(str.length());
		char[][] board = convert(str);
		System.out.println(isValidSudoku(board));
	}
}
