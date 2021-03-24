package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));
	}

	public static int trap(int[] a) {
		int n = a.length;

		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		// left max to the ith number
		for (int i = 1; i < n - 1; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], a[i - 1]);
		}

		// right max to the ith
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], a[i + 1]);
		}

		int total = 0;
		for (int i = 0; i < n; i++) {
			total += Math.max(0, Math.min(rightMax[i], leftMax[i]) - a[i]);
		}
		return total;
	}

}
