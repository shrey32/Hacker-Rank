package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Shrey
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		System.out.println(
				spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }));// 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));// 1,2,3,6,9,8,7,4,5
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } }));// 1,2,3,6,9,12,11,10,7,4,5,8
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));// 1,2,3,4,8,12,11,10,9,5,6,7,8
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));// 1,2,3,6,5,4
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		List<Integer> result = new ArrayList<>(m * n);

		int k = 0, l = 0;
		while (k < m && l < n) {
			// right
			for (int i = l; i < n - k; i++) {
				if (result.size() == m * n)
					break;
				result.add(matrix[k][i]);
			}
			k++;
			// down
			for (int i = k; i < m - l; i++) {
				if (result.size() == m * n)
					break;
				result.add(matrix[i][n - k]);
			}
			l++;
			// left
			for (int j = n - l - 1; j >= l - 1; j--) {
				if (result.size() == m * n)
					break;
				result.add(matrix[m - k][j]);
			}
			// up
			for (int i = m - k - 1; i >= k; i--) {
				if (result.size() == m * n)
					break;
				result.add(matrix[i][l - 1]);
			}

		}

		return result;
	}

}
