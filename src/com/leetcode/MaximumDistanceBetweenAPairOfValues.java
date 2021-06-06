package com.leetcode;

/**
 * 
 * @author Shrey
 *
 */
public class MaximumDistanceBetweenAPairOfValues {

	public static void main(String[] args) {
		System.out.println(maxDistance(new int[] { 55, 30, 5, 4, 2 }, new int[] { 100, 20, 10, 10, 5 }));// 2
		System.out.println(maxDistance(new int[] { 2, 2, 2 }, new int[] { 10, 10, 1 }));// 1
		System.out.println(maxDistance(new int[] { 30, 29, 19, 5 }, new int[] { 25, 25, 25, 25, 25 }));// 2
		System.out.println(maxDistance(new int[] { 5, 4 }, new int[] { 3, 2 }));// 0
	}

	public static int maxDistance(int[] nums1, int[] nums2) {
		int max = 0;
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j])
				i++;
			else {
				max = Math.max(max, j - i);
				j++;
			}
		}
		return max;
	}

}
