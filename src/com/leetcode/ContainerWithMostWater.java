package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

	}

	public static int maxArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len = height.length;
		int l = 0, r = len - 1;
		int max = 0;

		while (l < r) {

			max = Math.max(max, Math.min(height[l], height[r]) * (r - l));

			if (height[l] < height[r])
				l++;
			else
				r--;
		}

		return max;
	}

}
