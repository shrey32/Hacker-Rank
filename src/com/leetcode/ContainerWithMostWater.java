package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }, false));
		System.out.println(maxArea(new int[] { 1, 1 }, false));
		System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }, false));
		System.out.println(maxArea(new int[] { 1, 2, 1 }, false));
	}

	public static int maxArea(int[] height, boolean val) {
		if (height == null || height.length <= 1)
			return 0;
		if (height.length == 2)
			return Math.min(height[0], height[1]);

		int max = 0;

		for (int i = 0; i < height.length; i++) {
			int start = height[i];
			int count = 0;
			for (int j = i + 1; j < height.length; j++) {
				int next = height[j];
				count++;
				max = Math.max(max, count * Math.min(start, next));
			}
		}

		return max;
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
