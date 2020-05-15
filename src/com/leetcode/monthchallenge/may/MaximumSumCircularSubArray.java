package com.leetcode.monthchallenge.may;

/**
 * <b>Maximum Sum Circular Subarray</b>
 * 
 * @author Shrey
 *
 */
public class MaximumSumCircularSubArray {

	public static void main(String[] args) {
		System.out.println(maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));// 3
		System.out.println(maxSubarraySumCircular(new int[] { 5, -3, 5 }));// 10
		System.out.println(maxSubarraySumCircular(new int[] { 3, -1, 2, -1 }));// 4
		System.out.println(maxSubarraySumCircular(new int[] { 3, -2, 2, -3 }));// 3
		System.out.println(maxSubarraySumCircular(new int[] { -2, -3, -1 }));// -1
	}

	public static int maxSubarraySumCircular(int[] a) {
		if (a.length == 0)
			return 0;
		int sum = a[0];
		int maxSoFar = a[0];
		int maxTotal = a[0];
		int minTotal = a[0];
		int minSoFar = a[0];
		for (int i = 1; i < a.length; i++) {
			int num = a[i];
			maxSoFar = Math.max(num, maxSoFar + num);
			maxTotal = Math.max(maxSoFar, maxTotal);

			minSoFar = Math.min(num, minSoFar + num);
			minTotal = Math.min(minTotal, minSoFar);

			sum += num;
		}
		if (sum == minSoFar)
			return maxTotal;
		return Math.max(sum - minTotal, maxTotal);
	}

}
