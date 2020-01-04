package com.geekforgeeks.google;

import java.util.Arrays;

/**
 * <a href=
 * "https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0">Subarray
 * with given sum</a>
 * 
 * @author Shrey
 *
 */
public class SubArrayForGivenSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(subArrayWithGivenSum(new int[] { 1, 2, 3, 7, 5 }, 12)));// 2,4

		System.out.println(Arrays.toString(subArrayWithGivenSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 15)));// 1,5

		System.out.println(Arrays.toString(subArrayWithGivenSum(new int[] { 135, 101, 170, 125, 79, 159, 163, 65, 106,
				146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139,
				70, 113, 68, 100, 36, 95, 104, 12, 123, 134 }, 468)));// 38,42

		System.out.println(Arrays.toString(subArrayWithGivenSum(new int[] { 142, 112, 54, 69, 148, 45, 63, 158, 38, 60,
				124, 142, 130, 179, 117, 36, 191, 43, 89, 107, 41, 143, 65, 49, 47, 6, 91, 130, 171, 151, 7, 102, 194,
				149, 30, 24, 85, 155, 157, 41, 167, 177, 132, 109, 145, 40, 27, 124, 138, 139, 119, 83, 130, 142, 34,
				116, 40, 59, 105, 131, 178, 107, 74, 187, 22, 146, 125, 73, 71, 30, 178, 174, 98, 113 }, 665)));// -1

		System.out.println(Arrays.toString(subArrayWithGivenSum(new int[] { 15, 2, 4, 8, 9, 5, 10, 23 }, 23)));// 2,5
	}

	/**
	 * sliding window strategy, keep on adding ith array element to currSum if
	 * currSum exceeds given sum, subtract elements from the start. If currSum
	 * matches given sum, then return. Return -1, when loop ends.
	 * 
	 * @param a
	 * @param s
	 * @return
	 */
	private static final int[] subArrayWithGivenSum(int[] a, int s) {
		int n = a.length, currSum = a[0], start = 0;

		for (int i = 1; i <= n; i++) {

			while (currSum > s && start < i - 1) {
				currSum = currSum - a[start];
				start++;
			}
			// If curr_sum becomes equal to sum, then return true
			if (currSum == s) {
				return new int[] { start + 1, i };
			}

			if (i < n)
				currSum = currSum + a[i];
		}

		return new int[] { -1 };
	}

}
