package com.leetcode;

import java.util.Arrays;

/**
 * 
 * @author Shrey
 *
 */
public class SearchA2DMatrixII {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
		System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
	}

	public static boolean searchMatrix(int[][] mat, int target) {
		if (mat == null || mat.length == 0 || mat[0].length == 0)
			return false;
		int m = mat.length;

		for (int i = 0; i < m; i++) {
			int first = mat[i][0];
			if (first == target)
				return true;
			if (first > target)
				return false;

			int ind = Arrays.binarySearch(mat[i], target);
			if (ind >= 0)
				return true;
		}
		return false;
	}

}
