package com.leetcode.monthchallenge.april;

import java.util.Arrays;
import java.util.List;

/**
 * <b>Leftmost Column with at Least a One</b>
 * <p>
 * <p>
 * (This problem is an interactive problem.)
 * </p>
 * 
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row
 * of the matrix, this row is sorted in non-decreasing order.
 * </p>
 * 
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column
 * index(0-indexed) with at least a 1 in it. If such index doesn't exist, return
 * -1.
 * </p>
 * 
 * <p>
 * You can't access the Binary Matrix directly. You may only access the matrix
 * using a BinaryMatrix interface:
 * </p>
 * 
 * <p>
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y)
 * (0-indexed). BinaryMatrix.dimensions() returns a list of 2 elements [n, m],
 * which means the matrix is n * m. Submissions making more than 1000 calls to
 * BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that
 * attempt to circumvent the judge will result in disqualification.
 * </p>
 * 
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in
 * the following four examples. You will not have access the binary matrix
 * directly.
 * </p>
 * </p>
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: mat = [[0,0],[1,1]] Output: 0 Example 2:
 * 
 * 
 * 
 * Input: mat = [[0,0],[0,1]] Output: 1 Example 3:
 * 
 * 
 * 
 * Input: mat = [[0,0],[0,0]] Output: -1 Example 4:
 * 
 * 
 * 
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]] Output: 1
 * 
 * 
 * <p>
 * <b>Constraints:</b>
 * 
 * <p>
 * <li>1 <= mat.length, mat[i].length <= 100 mat[i][j] is either 0 or 1. mat[i]
 * is sorted in a non-decreasing way.</li>
 * <li>Hint #1 1. (Binary Search) For each row do a binary search to find the
 * leftmost one on that row and update the answer.</li>
 * <li>Hint #2 2. (Optimal Approach) Imagine there is a pointer p(x, y) starting
 * from top right corner. p can only move left or down. If the value at p is 0,
 * move down. If the value at p is 1, move left.</li>
 * <p>
 * Try to figure out the correctness and time complexity of this algorithm.
 * </p>
 * </p>
 * </p>
 * 
 * @author Shrey
 *
 */
public class LeftmostColumnWithAtLeastAOne {

	public static void main(String[] args) {
		System.out.println(leftMostColumnWithOne(new BinaryMatrix()));
	}

	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dim = binaryMatrix.dimensions();
		int rows = dim.get(0);
		int cols = dim.get(1);

		if (rows == 0 || cols == 0)
			return 1;
		int result = -1;
		int r = 0, c = cols - 1;
		while (r < rows && c >= 0) {
			if (binaryMatrix.get(r, c) == 1) {
				result = c;
				c--;
			} else {
				r++;
			}
		}
		return result;
	}

	private static class BinaryMatrix {
		private int[][] matrix;

		public BinaryMatrix() {
			this.matrix = new int[0][0];
		}

		public int get(int x, int y) {
			return this.matrix[x][y];
		}

		public List<Integer> dimensions() {
			return Arrays.asList(this.matrix.length, this.matrix[0].length);
		}
	};

}
